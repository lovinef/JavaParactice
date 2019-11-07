package Algorithm.DoIt;

/*
* 선형 검색을 확장한 알고리즘
* */
public class BruteForce {
    /*
        다른 문자를 만나면 패턴에서 문자를 검색했던 위치 결과를 버리고 다음 텍스트 위치로 이동하여,
        다시 패턴의 처음부터 검사.
        text에서 pattern 을 검색하여 텍스트의 시작 위치를 반환한다.
        없을 경우 -1 반환
    */
    public static int bfMatch(final String text, final String pattern){
        int textPosition = -1;
        int patternPosition = 0;
        while(textPosition < text.length()){
            textPosition += 1;
            if(text.charAt(textPosition) == pattern.charAt(patternPosition)){   // 현재 문자가 같다면 추가 진행
                patternPosition += 1;
            }else{
                patternPosition = 0;    // 문자가 다르다면 패턴 위치 초기화
            }

            // 같은 패턴의 문자가 있으면 패턴 문자 시작 위치 반환
            if(patternPosition == pattern.length()){
                textPosition -= (patternPosition - 1);  // 배열은 0부터 시작하므로 -1 처리.
                break;
            }

            // 마지막 까지 같은 패턴의 문자를 찾지 못했다면 -1 리턴
            if(textPosition == text.length() - 1 && patternPosition != pattern.length()){
                textPosition = -1;
                break;
            }
        }

        return textPosition;
    }

    public static void main(String[] args) {
        String wholeText = "ABC가나다DEFG";
        String pattern = "DEFG";

        System.out.println(pattern.length());
        System.out.println(bfMatch(wholeText, pattern));
    }
}
