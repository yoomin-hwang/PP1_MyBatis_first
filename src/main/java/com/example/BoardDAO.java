package com.example;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class BoardDAO {

    JdbcTemplate template;
    ResultSet rs = null;

    private final String BOARD_INSERT = "insert into BOARD (category,title, writer, content) values (?,?,?,? )";
    private final String BOARD_UPDATE = "update BOARD set category=?, title=?, writer=?, content=? where seq=?";
    private final String BOARD_DELETE = "delete from BOARD  where seq=?";
    private final String BOARD_GET = "select * from BOARD  where seq=?";
    private final String BOARD_LIST = "select * from BOARD order by seq desc";


    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public int insertBoard(BoardVO vo) {
        System.out.println("===> JDBC로 insertBoard() 기능 처리");
        return template.update(BOARD_INSERT);
    }

    // 글 삭제
    public int deleteBoard(int seq) {
        System.out.println("===> JDBC로 deleteBoard() 기능 처리");
        return template.update(BOARD_DELETE);
    }
    public int updateBoard(BoardVO vo) {
        System.out.println("===> JDBC로 updateBoard() 기능 처리");
        return template.update(BOARD_UPDATE);
    }

    public BoardVO getBoard(int seq) {
        BoardVO one = new BoardVO();
        System.out.println("===> JDBC로 getBoard() 기능 처리");
        return template.queryForObject(BOARD_GET, new Object[]{seq}, new BeanPropertyRowMapper<BoardVO>(BoardVO.class));
    }

    public List<BoardVO> getBoardList(){
        List<BoardVO> list = new ArrayList<BoardVO>();
        System.out.println("===> JDBC로 getBoardList() 기능 처리");
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(BOARD_LIST);
            rs = stmt.executeQuery();
            while(rs.next()) {
                BoardVO one = new BoardVO();
                one.setSeq(rs.getInt("seq"));
                one.setCategory(rs.getString("category"));
                one.setTitle(rs.getString("title"));
                one.setWriter(rs.getString("writer"));
                one.setContent(rs.getString("content"));
                one.setRegdate(rs.getDate("regdate"));
                list.add(one);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

//    public String getImgFilename(int seq) {
//        String filename = null;
//        try{
//            conn = JDBCUtil.getConnection();
//            stmt = conn.prepareStatement(BOARD_GET);
//            stmt.setInt(1, seq);
//            rs = stmt.executeQuery();
//            if(rs.next())
//                filename = rs.getString("img");
//            rs.close();
//        } catch(Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("===> JDBC로 getImgFilename() 기능 처리");
//        return filename;
//    }
}
