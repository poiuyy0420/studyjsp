package ch11.logon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class LogonDBBean {
	
	//LogonDBBEan ������ü���� > �� ���� ��ü�� �����ؼ� ����
	private static LogonDBBean instance = new LogonDBBean();
	
	//LogonDBBean ��ü�� �����ϴ� �޼ҵ�
	public static LogonDBBean getInstance() {
		return instance;
	}
	
	private LogonDBBean() {}
	
	//Ŀ�ؼ� Ǯ���� Ŀ�ؼ� ��ü�� ���� �޼ҵ�
	private Connection getConnection() throws Exception{
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource)envCtx.lookup("jdbc/myOracle");
		return ds.getConnection();	
	}
	
	//ȸ������ó��(registerPro.jsp)���� ����ϴ� �� ���ڵ� �߰� �޼ҵ�
	public void insertMember(LogonDataBean member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			
			
			pstmt = conn.prepareStatement("insert into member values (?,?,?,?,?,?)");
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPasswd());
			pstmt.setString(3, member.getName());
			pstmt.setTimestamp(4, member.getReg_date());
			pstmt.setString(5, member.getAddress());
			pstmt.setString(6, member.getTel());
			pstmt.executeUpdate();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(pstmt!=null)try {pstmt.close();}catch(SQLException ex) {}
			if(conn!=null)try {conn.close();}catch(SQLException ex) {}
		}
	}
	
	//���̵� �ߺ� Ȯ��(confirmId.jsp)���� ���̵��� �ߺ� ���θ� Ȯ���ϴ� �޼ҵ�
	public int confirmId(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = -1;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select id from member where id=?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next())//���̵� ����
				x = 1; //���� ���̵� ����
			else
				x = -1; //���� ���̵� ����
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(rs!=null)try {rs.close();}catch(SQLException ex) {}
			if(pstmt!=null)try {pstmt.close();}catch(SQLException ex) {}
			if(conn!=null)try {conn.close();}catch(SQLException ex) {}
		}
		return x;
	}
	
	//�α��� �� ó��(loginPro.jsp)�������� ����� ���� ó�� ��
	//ȸ�� ���� ����/Ż�� ����� ����(memberCheck.jsp)���� ����ϴ� �޼ҵ�
	public int userCheck(String id, String passwd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = -1;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select passwd from member where id = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) { //�ش� ���̵� ������ ����
				String dbpasswd = rs.getString("passwd");
				if(passwd.equals(dbpasswd))
					x=1; //��������
				else
					x=0; //��й�ȣ Ʋ��
			}else //�ش� ���̵� ������ ����
				x=-1; //���̵� ����
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(rs!=null)try {rs.close();}catch(SQLException ex) {}
			if(pstmt!=null)try {pstmt.close();}catch(SQLException ex) {}
			if(conn!=null)try {conn.close();}catch(SQLException ex) {}
		}
		return x;
	}
	
	//ȸ����������ǰ(modifyForm.jsp)�� ���� ���� ���� ������ �������� �޼ҵ�
	public LogonDataBean getMember(String id, String passwd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		LogonDataBean member = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select*from member where id=?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) { //�ش� ���̵� ���� ���ڵ尡 ����
				String dbpasswd=rs.getString("passwd");
				//����ڰ� �Է��� ��й�ȣ�� ���̺��� ��й�ȣ�� ������ ����
				if(passwd.equals(dbpasswd)) {
					member = new LogonDataBean();
					member.setId(rs.getString("id"));
					member.setName(rs.getString("name"));
					member.setReg_date(rs.getTimestamp("reg_date"));
					member.setAddress(rs.getString("address"));
					member.setTel(rs.getString("tel"));
				}
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(rs!=null)try {rs.close();}catch(SQLException ex) {}
			if(pstmt!=null)try {pstmt.close();}catch(SQLException ex) {}
			if(conn!=null)try {conn.close();}catch(SQLException ex) {}
		}
		return member; //������ ����� ��ü member ����
	}
	
	//ȸ������ ����ó��(modifyPro.jsp)���� ȸ������ ������ ó���ϴ� �޼ҵ�
	public int updateMember(LogonDataBean member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = -1;
		try {
			conn = getConnection();
			String pass = member.getPasswd();
			
			pstmt = conn.prepareStatement("select passwd from member where id = ?");
			pstmt.setString(1, member.getId());
			rs = pstmt.executeQuery();
			
			if(rs.next()) { //�ش� ���̵� ������ ����
				String dbpasswd = rs.getString("passwd");
				if(pass.equals(dbpasswd)) {
					pstmt = conn.prepareStatement("update member set name=?,address=?,tel=? "+"where id=?");
					pstmt.setString(1, member.getName());
					pstmt.setString(2, member.getAddress());
					pstmt.setString(3, member.getTel());
					pstmt.setString(4, member.getId());
					pstmt.executeUpdate();
					x=1; //ȸ�� ����  ���� ó�� ����
				}else
					x=0; //ȸ�� ���� ���� ó�� ����
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(rs!=null)try {rs.close();}catch(SQLException ex) {}
			if(pstmt!=null)try {pstmt.close();}catch(SQLException ex) {}
			if(conn!=null)try {conn.close();}catch(SQLException ex) {}
		}
		return x;
	}
	
	//ȸ��Ż��ó��(deletePro.jsp)���� ȸ�� ������ �����ϴ� �޼ҵ�
	public int deleteMember(String id, String passwd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = -1;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select passwd from member where id = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String dbpasswd = rs.getString("passwd");
				if(passwd.equals(dbpasswd)) {
					pstmt = conn.prepareStatement("delete from member where id=?");
					pstmt.setString(1, id);
					pstmt.executeQuery();
					x=1; //ȸ��Ż��ó�� ����
				}else
					x=0; //ȸ��Ż��ó�� ����
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(rs!=null)try {rs.close();}catch(SQLException ex) {}
			if(pstmt!=null)try {pstmt.close();}catch(SQLException ex) {}
			if(conn!=null)try {conn.close();}catch(SQLException ex) {}
		}
		return x;
	}

}
