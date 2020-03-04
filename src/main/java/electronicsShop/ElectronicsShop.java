package electronicsShop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.*;
import java.util.stream.Collectors;

/**
 * https://www.hackerrank.com/challenges/electronics-shop/problem?h_r=internal-search
 */
public class ElectronicsShop {
    private Logger logger = LogManager.getLogger(this.getClass());
    private int result; //결과값
    private int cost;   //키보드와 USB 합 금액
    private int budget; //모니카 예산
    private List<Integer> listKeyboards; //키보드 종류 금액 리스트
    private List<Integer> listDrive;    //UBB 종류별 금액 리스트

    private void ElectronicsShop(){
        result = -1;
        cost = 0;
        budget = 0;
    }
    /**
     *
     * @param keyboards 키보드 종류 별 금액 배열
     * @param drives  usb 종류뵬 금액 배열
     * @param b 모니카 예산
     * @return
     */
    public int getMoneySpent(int[] keyboards, int[] drives, int b) {
        setBudget(b); //모니카 예산 설정
        initSortToList(keyboards, drives); //키보드, usb 금액 내림차순 정렬
        if(isShoppable(b)) return result; //제일 저렴한 품목 합과 모니카 예산 체크 (모니카 예산이 적으면 -1 반환
        calcResult(); // 모니카 예산보다 적은 금액의 최대값 연산
        return  result;
    }

    private void setBudget(int b) {
        budget = b;
    }

    /**
     * 내림차순 sort
     * @param keyboards
     * @param drives
     */
    private void initSortToList(int[] keyboards, int[] drives){
        listKeyboards = Arrays.stream(keyboards).boxed().collect(Collectors.toList());
        listDrive = Arrays.stream(drives).boxed().collect(Collectors.toList());
        Collections.sort(listKeyboards, Comparator.reverseOrder());
        Collections.sort(listDrive, Comparator.reverseOrder());
    }

    /**
     *  내림차순으로 정렬된 배열의 마지막 값은 제일 저렴한 상품이므로 저렴상품 합보다 예산이 크면 구매가 가능하다
     * @param b 모니카 예산
     * @return 예산이 최저 금액 상품보다 크면 true
     */
    private boolean isShoppable(int b){
        return (listKeyboards.get(listKeyboards.size()-1) + listDrive.get(listDrive.size()-1) > b);
    }

    /**
     * 예산내 최대 금액 연산
     */
    private void calcResult(){
        for(int costKeyboard : listKeyboards){
            for(int costDrive : listDrive){
                cost = costDrive + costKeyboard;
                if(cost <= budget){ //usb drive와 keyboard 합의 금액이 예산보다 작거나 같은 경우면 구매가 가능
                    if(cost == budget){ //예산과 동일하면 더 이상 필요없이 최대 예산으로 구매 경우이다.
                        result = cost;
                        break;
                    }else{
                        if(result < cost){ //예산으로 구매가 가능한 경우, 최대 금액으로 변경
                            result = cost;
                        }
                    }
                }
            }
        }
    }
}
