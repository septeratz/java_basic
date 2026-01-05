package main;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.log4j.Logger;
import model.domain.GameType;
import model.domain.Person;
import model.domain.Score; // Score 클래스 import 필수

public class Main {
    
    static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        

        List<Person> players = new ArrayList<>();
        players.add(new Person("이명진"));
        players.add(new Person("강민영"));
        players.add(new Person("이승준"));
        players.add(new Person("이유진"));

        logger.info("=== 게임 시스템 시작 ===");


        Person currentPlayer = players.get(1); 
        GameType currentGame = GameType.GAME_A;
        int newPoint = 150; // 이번 점수
        
        // 이전 순위 불러오기
        int oldRank = getRank(players, currentPlayer, currentGame);

        // 점수 업데이트
        int scoreDiff = currentPlayer.updateScore(currentGame, newPoint);

        if (scoreDiff > 0) {
            logger.info("[신기록] " + currentPlayer.getName() + "님이 " + currentGame.getName() + " 종목 기록을 +"+ scoreDiff + "점 갱신!");

            // 게임 후 내 등수 확인
            int newRank = getRank(players, currentPlayer, currentGame);

            // [Step 4] 등수 비교 및 랭킹 출력
            if (newRank < oldRank) {
                int rankUp = oldRank - newRank;
                logger.info("[순위상승] " + oldRank + "위 -> " + newRank + "위 (" + rankUp + "계단 상승)");
                
                // 전체 랭킹판 출력
                printAllRanking(players, currentGame);
            } else {
                logger.info("[순위유지] 현재 " + newRank + "위입니다.");
            }

        } 

    }

    // -----------------------------------------------------
    // [도우미 메소드 1] 등수 구하기 (Score 객체 처리 버전)
    // -----------------------------------------------------
    public static int getRank(List<Person> list, Person target, GameType type) {
        // 내림차순 정렬 (점수 높은 사람이 1등)
        Collections.sort(list, (p1, p2) -> {
            // Map에서 Score 객체를 꺼냄 (없으면 null)
            Score s1 = p1.getBestScores().get(type);
            Score s2 = p2.getBestScores().get(type);
            
            // Score 객체가 null이면 0점 처리, 있으면 getPoint()로 점수 추출
            // ※ 주의: Score 클래스 필드명이 score라면 getScore(), point라면 getPoint()
            int point1 = (s1 == null) ? 0 : s1.getPoint(); 
            int point2 = (s2 == null) ? 0 : s2.getPoint();
            
            return point2 - point1; // 내림차순
        });

        return list.indexOf(target) + 1;
    }

    // -----------------------------------------------------
    // [도우미 메소드 2] 랭킹 출력 (타임스탬프 포함 버전)
    // -----------------------------------------------------
    public static void printAllRanking(List<Person> list, GameType type) {
        logger.info("=== [" + type.getName() + "] 실시간 랭킹 ===");
        
        // 날짜 예쁘게 출력하기 위한 포맷터
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        for (int i = 0; i < list.size(); i++) {
            Person p = list.get(i);
            Score record = p.getBestScores().get(type);

            if (record != null) {
                String timeStr = record.getRecordDate().format(dtf);
                logger.info((i + 1) + "위 : " + p.getName() + " (" + record.getPoint() + "점) - " + timeStr + " 달성");
            } else {
                logger.info((i + 1) + "위 : " + p.getName() + " (기록 없음)");
            }
        }
        logger.info("==================================");
    }
}