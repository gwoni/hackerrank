package birthdayChoocolate;

import java.util.List;

public class BirthdayChocolate {
    public int solve(List<Integer> s, int d, int m) {
        int result =0;
        if(s.size()==1){
            int sum =0;
            List<Integer> temp = s.subList(0,m);
            for(int chocolate : temp){
                sum += chocolate;
            }
            if(sum == d) result++;
        }else{
            for(int idx=0; idx< s.size()-m; idx++){
                int sum =0;
                List<Integer> temp = s.subList(idx,idx+m);
                for(int chocolate : temp){
                    sum += chocolate;
                }
                if(sum == d) result++;
            }
        }

        return result;

    }
}
