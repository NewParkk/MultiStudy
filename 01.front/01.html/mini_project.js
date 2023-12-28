
// p 태그에 설정해놓은 dynamic을 지정하여 변수에 할당
let target = document.querySelector("#dynamic");


function randomString(){
    let stringArr = ["Learn to HTML", "Learn to CSS", "Learn to JavaScript", "Learn to Front-End"
                    , "Learn to Back-End"];
    // random함수로 배열크기 이하 난수생성
    // floor로 뒤에 소수점 버려 정수로 반환
    let selectString = stringArr[Math.floor(Math.random()*stringArr.length)]
    // 반환된 문자열 문자하나씩 배열로 쪼갬
    let selectStringArr = selectString.split("");

    return selectStringArr;
}



// p 내용 지우기
function resetTyping(){
    target.textContent = "";
    dynamic(randomString());
}


// 한글자씩 텍스트 출력함수
// selectStringArr배열을 앞에서 부터 하나씩 빼냄
function dynamic(randomArr){
    if(randomArr.length >0){
        // p 태그에 shift로 빼낸 값을 하나씩 전달
        target.textContent += randomArr.shift();
        console.log(target.textContent)
        // setTimeout 함수로 80ms후에 dynamic함수를 다시 호출하여
        // 배열이 0이 될때까지 반복
        setTimeout(function(){
            dynamic(randomArr);
        },80);
    }else{
        // 배열이 0이면 3초뒤 resetTyping 실행
        setTimeout(resetTyping, 3000);
    }
}

// 함수 실행
dynamic(randomString());


// setInterval 함수를 이용
// blink라는 함수가 500ms(0.5초)마다 호출되었다 안되었다 반복
// 함수 실행
setInterval(blink, 500);

// js로 active 클래스를 toggle 메서드이용하여 없앰
function blink(){
    // active 클래스가 추가되었다 사라졌다를 반복하게 하기위해
    target.classList.toggle("active");
}





// 눈만들기
function createSnow(){
    // div요소 생성하는 변수 지정
    let el = document.createElement("div");
    el.classList.add('snow');
    el.style.marginLeft = randomPosition() + 'px';
    document.body.appendChild(el);
}

// 눈 여기저기 뿌리기
function randomPosition(){
    return Math.floor(Math.random() * window.innerWidth);
}

// 눈 마구 뿌리기
for(let i = 0; i< 300; i++){
    createSnow();
}


function menuClick(num){
    
    for(var i=1; i <= 3; i++){
        if(num == i){
            document.getElementById("dropMenu"+i).className += ' active';
        }
        else {
            document.getElementById("dropMenu"+i).className = 'dropdown';
        }
    }

}
































// $(document).ready(function(){
//     $('.menu-toggle').click(function(){
//       $('nav').toggleClass('active');
//     });
  
//     $('ul li').click(function(){
//       $(this).siblings().removeClass('active');
//       $(this).toggleClass('active');
//     })
//   })