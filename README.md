개발자 : 
곽명석(경희대학교 소프트웨어융합학과), 
이호욱(경희대학교 소프트웨어융합학과)

# A. 소개
시각장애인을 위한 상품 인식 어플리케이션

# B. 개발 동기
 시각장애인들이 장을 볼 때 눈 앞의 상품을 쉽게 식별하지 못하는 불편함을 덜어주기 위해 개발했다. 비시각장애인들이 사용하는 일반적인 어플리케이션과 다르게 만들고 싶어, 시각을 대신하여 청각적 요소로 페이지를 안내해주고, 직관적인 화면전환을 위해 왼쪽에서 오른쪽으로 밀어내는 것과 같은 스와이프 방식을 도입했다.

# C. 기능
음성인식
TTS(Text To Speech): 
스와이프 감지를 통한 화면 전환
바코드 인식을 통한 상품 식별, 음성 안내
ocr 기능을 통한 상품 식별 및 성분 인식, 음성 안내

# D. 어플리케이션 사용 방법 및 각 Activity 소개
Main Page : 어플리케이션 소개 및 페이지 전환 방법 소개
R - 1 : 바코드 인식 기능 페이지
R - 2 : 이미지 인식 기능 ( 기능 탑재 실패)
R - 3: OCR (텍스트 인식) 
U - 1 : 음성인식 기능 (페이지 전환)
D - 1 :  R - 2 페이지에서 위에서 밑으로 Swipe 시 Main Page로 돌아감

# E. 어플리케이션 기능 , 화면전환 사용 방법
바코드 인식 기능( R - 1 ) : 카메라를 통한 상품의 바코드를 인식함으로써 상품 설명
OCR(R - 3) : 상품에 쓰여있는 글씨(사실 어떤 글씨던지 상관 없음)를 text로 전환해서 음성으로 읽어주는 기능을 곧 구현할 예정
음성인식 기능(U - 1)  : 바코드, OCR 기능을 음성 인식을 하여(“바코드 인식 열어줘”) 해당 페이지로 전환
이미지 인식 기능 ( R - 2 ) : 기능 탑재 실패
화면전환 : Swipe를 통해 화면 전환( EX : 오른쪽에서 왼쪽 으로 화면을 밀게 되면 R - 1 화면 전환 즉, 가고 싶은 페이지 방향에서 반대로 밀게 되면 화면 전환)



# F. 상품 바코드 데이터 수집 경로
 대한상공회의소 유통물류진흥원에 바코드 데이터를 구하기 위해 문의를 해보았으나, 받지 못했다. 바코드 데이터는 어플에 필수적인 데이터이기 때문에, 롯데슈퍼(http://www.lottesuper.co.kr/handler/Index-Start) 웹사이트에 있는 바코드와 상품명을 크롤링을 통해 수집하였다. 




# G. 결론 및 분석 , 느낀점
결과적으로 어플리케이션 개발은 실패 하였다. 그렇기에 실패 이유를 분석하여 정리해 보았다.


### a. 실패 분석
개발자들의 능력 부족
 	제일 중요한 요소인 개발 능력이 굉장히 부족하였다. 기본적으로 Java , android에 대한 
이해도와 지식 보유를 고려하지 않고 맨땅에 헤딩식으로 개발 한 결과 초기에 구상 하였던 
어플리케이션에 대한 기능 , 접근성 등을 구현하지 못하였다.
즉, SWOT 분석을 실패하였다고 볼 수 있다.
개발자들의 강점과 약점 등을 분석하여 개발 툴과 사용 언어 등을 고려하여 개발에 앞서 선택을 했어야 했다. 

개발에 대한 설계 계획 부족
단순히 시각장애인을 위한 상품인식 어플리케이션을 만들고자 하였고 그에 따른 필요한 기능만 탑재할려는 단순한 그림만 그리고 개발을 시작하였다. 그렇기에 자료 부족 , 설계 방향 , 기간 설정 , 어플리케이션 접근성 등 전혀 고려하지 않고 단순히 결과만을 만들려고 하다가 개발 도중 프로젝트 자체를 다시 만들어 방향성을 잡고 다시 시작하는 경험을 하게 되었다.
즉, 서비스 기획 단계 자체를 실패하였다.

제품의 완성도
위의 1, 2를 종합하여 판단할 때, 이 어플리케이션을 어플 시장에 출시를 한다면, 실 사용자가 이것을 사용할만큼의 퀄리티가 높다고 판단하지 않았다. 그 이유는, 어플리케이션 타겟 사용자인 시각장애인들이 바코드 인식을 할 때 상품의 바코드 위치를 찾기 힘들 것이며, ocr 또한 좋은 인식률이 아니라고 판단하였기 때문이다. 


### b. 보완할 점
개발시에 개발자들의 SWOT를 정확히 분석하여 개발 언어 , Tool 등을 선택하여 각 개발자들이 맡아야 할것과 공부할 수 있는것 등을 분업하여야한다.
제작 계획을 철저히 ,제작 계획으로는 서비스 계획 , 디자인 , 개발, 출시 방법등에 대한 계획을 세워야 한다. 즉,  누가 사용할 것이며 어떻게 접근하게 만들것이며 어떤 기능을 넣을 것이며 디자인은 어떻게 구현 할 것인지 등 큰 줄기를 잡아야한다.
정확한 날짜를 계획하여 언제까지 개발한것인지에 대한 시간 에 대한 계획을 철저히 지켜야 한다.




### c. 얻은 점
첫 개발로 얻은 것들을 정리해 보았다. 
둘이서 개발을 해나가면서 협업의 프로세스를 이해하게 되었다. 깃허브를 사용하면서 공동 개발을 진행하는 방법도 몸에 익혔고, 서로간의 의견조율을 통해 혼자서 내는 아이디어보다 좋은 아이디어를 도출하게 된 경우도 있었다. 
무엇이 부족한지 알게 되었다. 개발자 둘 다 자바 개발 경험도, 안드로이드 어플리케이션 개발 경험도 전무한지라 맨 땅에 헤딩하는 식으로 개발을 진행하였기 때문에, 가장 기본적인 dependency같은 것들도 몰랐다. 매번 유튜브 강의, 구글링, document를 참고해가면서 그때그때 필요한 코드 및 로직을 이해하는 방식이었다. 기본기가 별로 없는 상태에서 이러한 방식에 의존하는 것은 개발 속도, 프로그램의 질, 그리고 효율적 개발에 매우 치명적이라는 것을 알게되었다. 
학교에서 프로그래밍 수업때 만들었던 프로그램들과는 달리 고려해야할 사항도 많았다. 또한 학교 수업에서는 이 프로그램에는 이런 알고리즘을 사용하면 된다는 지침이 있었지만, 이와 달리 우리가 한 개발은 어떠한 지침도 주어지지 않았다. 내가 어떤 로직을 쓰느냐, 어떤 코드를 작성하느냐에 따라 프로그램의 퀄리티가 바뀐다는 것을 알게 되었고, 개발의 어려움을 몸소 느끼게 되었다. 따라서 학교에서 하는 것뿐만 아니라, 직접 나만의 프로그램들을 만들어봐야 내 진짜 실력이 생긴다는 것을 느꼈다. 



# H. 참고 자료 
STT, TTS 사용법
https://vvh-avv.tistory.com/148

TTS 사용법
https://m.blog.naver.com/PostView.nhn?blogId=ish430&logNo=220253484420&proxyReferer=https%3A%2F%2Fwww.google.com%2F

TTS Intent 홍드로이드 보고 TTS는 이걸로 활용함
https://sharp57dev.tistory.com/27

뷰페이지
https://itpangpang.xyz/284

화면전환 종류
https://202psj.tistory.com/826

swipe 화면전환
https://thdev.tech/androiddev/2017/05/06/Android-Studio-Create-Swipe-View/


안드로이드 zxing 사용
https://park-duck.tistory.com/108?category=843507

핸드폰 연결방법
https://developer.android.com/studio/debug/index.html


안드로이드 깃허브 연동
https://webnautes.tistory.com/1057

안드로이드 스튜디오 개발자 가이드
https://developer.android.com/guide?hl=ko

STT
https://www.youtube.com/watch?v=zHgATbPcq04

구글 음성 이용
https://kwon8999.tistory.com/entry/%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C-%EA%B5%AC%EA%B8%80-%EC%9D%8C%EC%84%B1APISpeechRecognizer-tutorial


레이아웃 구성하기
https://newgenerationkorea.wordpress.com/2015/07/18/layout-%EA%B5%AC%EC%84%B1%ED%95%98%EA%B8%B0-linearlayout%EA%B3%BC-relativelayout/



텍스트인식
https://yeolco.tistory.com/67?category=757621
https://puzzleleaf.tistory.com/58


https://hjiee.tistory.com/entry/Android-TessTwo%EB%A5%BC-%EC%9D%B4%EC%9A%A9%ED%95%9C-OCR-%EC%95%B1-%EB%A7%8C%EB%93%A4%EA%B8%B0%EB%AC%B8%EC%9E%90%EC%9D%B8%EC%8B%9D

OCR기술 이용 어플 만들기(OCR개념등 개인 경험까지 적혀있음)
https://m.blog.naver.com/PostView.nhn?blogId=gomulsum&logNo=220951149927&proxyReferer=https%3A%2F%2Fwww.google.com%2F

permission 추가방법
https://wowon.tistory.com/148


manufests에 있는 안드로이드manifest.xml -> provider의 "android.support.v4.content.FileProvider" 에러 해결 방법
출처: https://link2me.tistory.com/1682 [소소한 일상 및 업무TIP 다루기]


Tesseract로 OCR하기
https://joyhong.tistory.com/79

Tesseract로 안드로이드 OCR
https://cofs.tistory.com/268

Tesseract 안드로이드 적용방법 (OPENCV , NDK)
https://junyoung-jamong.github.io/computer/vision/2019/02/07/Android-Tesseract-%EC%82%AC%EC%9A%A9%ED%95%98%EA%B8%B0.html

OpenCV , 프로젝트 스트럭쳐 minsdk 오류 해결방법(곽명석의 경우 21로 바꿔야했다)
https://stackoverflow.com/questions/57685469/android-studio-error-manifest-merger-failed-uses-sdkminsdkversion

Tesseract 원리
https://jinseongsoft.tistory.com/41?category=655476


제스쳐 swipe
https://www.dev2qa.com/how-to-detect-swipe-gesture-direction-in-android/

안드로이드 개발
https://developer.android.com/training/swipe/add-swipe-interface?hl=ko


stt 설명
http://blog.daum.net/techtip/12414531

자바 class 예제 관련 상속 설명.
https://dev-jangwon.github.io/android/2017/04/14/java-android-class/

Blind_Project_01에 사용한 STT
https://medium.com/wasd/creating-an-android-google-stt-application-4cea24ee97af

네이버 API 음성인식 클로바
https://blog.naver.com/ndb796/221302622347

음성인식
https://stacktips.com/tutorials/android/speech-to-text-in-android


OCR
https://www.youtube.com/watch?v=fmTlgwgKJmE


바코드 인식
https://greatps1215.tistory.com/24

바코드 인식
https://superwony.tistory.com/78

바코드 인식 코드 해석
https://thegreedyman.tistory.com/14


안드로이드 파이어베이스 추가
https://firebase.google.com/docs/android/setup?hl=ko
https://j0n9m1n1.com/269

tesseract 학습법, 사용법
https://secmem.tistory.com/489

tesseract
https://m.blog.naver.com/cosmosjs/220937785735


gradle parse Error
https://comoi.io/248

OCR
https://www.youtube.com/watch?v=fmTlgwgKJmE
