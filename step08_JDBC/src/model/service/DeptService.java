package model.service;

import java.sql.SQLException;
import java.util.ArrayList;
import model.domain.DeptDAO;
import model.domain.DeptDTO;

public class DeptService {
    
    // DAO를 멤버 변수로 가짐 (Dependency Injection 준비)
    private DeptDAO deptDAO = new DeptDAO();

    public ArrayList<DeptDTO> getAllDepts() throws SQLException {
        return deptDAO.deptAll();
    }

    public boolean registerDept(DeptDTO dto) throws SQLException {
        // 여기서 데이터 검증 로직이 들어갈 수 있음 (예: 부서번호가 음수면 안됨 등)
        return deptDAO.insertDept(dto);
    }

    public boolean modifyDeptLoc(int deptno, String newLoc) throws Exception {
        return deptDAO.updateDept(deptno, newLoc);
    }
}