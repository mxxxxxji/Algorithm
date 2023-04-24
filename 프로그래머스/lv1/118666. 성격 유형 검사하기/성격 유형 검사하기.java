class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        int first = 0;
        int second = 0;
        int third = 0;
        int fourth = 0;
        
        for(int i=0; i<survey.length; i++){
            if(survey[i].charAt(0)=='R'){
                first += 4-choices[i];
            }else if(survey[i].charAt(0)=='T'){
                first += -(4-choices[i]);
            }else if(survey[i].charAt(0)=='C'){
                second += 4-choices[i];
            }else if(survey[i].charAt(0)=='F'){
                second += -(4-choices[i]);
            }else if(survey[i].charAt(0)=='J'){
                third += 4-choices[i];
            }else if(survey[i].charAt(0)=='M'){
                third += -(4-choices[i]);
            }else if(survey[i].charAt(0)=='A'){
                fourth += 4-choices[i];
            }else if(survey[i].charAt(0)=='N'){
                 fourth += -(4-choices[i]);
            }
        }
        
        if(first>=0) answer+="R";
        else answer+="T";
        if(second>=0) answer+="C";
        else answer+="F";
        if(third>=0) answer+="J";
        else answer+="M";
        if(fourth>=0) answer +="A";
        else answer+="N";
        
        return answer;
    }
}