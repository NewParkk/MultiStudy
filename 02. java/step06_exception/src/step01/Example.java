package step01;

public class Example {
	public static void main(String[] args) {
        try {
            exception1();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void exception1() throws NumberFormatException { //여러 예외들을 NumberFormatException로 묶어서 다룰 수 있다.
        try {
            start();
        } catch (ArithmeticException e) {//0 으로 나눌경우 Error //예외A(원인)
            NumberFormatException ne = new NumberFormatException("정수변환 안됨!에러!!");//예외B(새로운 예외에 포함시키기)
            ne.initCause(e);// 지정한 예외를 원인 예외로 등록
            throw ne; //예외 다시 던지기(예외 발생시킨다)
        } catch (ArrayIndexOutOfBoundsException e) {
            NumberFormatException ne = new NumberFormatException("정수변환 안됨!!에러1");
            ne.initCause(e);//예외 다시 던지기
            throw ne;
        } catch (Exception e) {
            throw e;
        }
    }
    static void start() {
//        throw new ArithmeticException();
        try {
            System.out.println(5/0); //1. ArithmeticException 발생시킴

//            int[] arr=new int[2];// 2. ArrayIndexOutOfBoundsException 발생시킴
//            arr[0]=100;
//            arr[2]=0;
//
//            int a=arr[0]/arr[1];
        } catch (ArithmeticException e) {
//            System.out.println("ArithmeticException 에러 발생!");
            throw e;
        } catch (ArrayIndexOutOfBoundsException e) {
//            System.out.println("ArrayIndexOutOfBoundsException에러발생!!(배열범위 에러)");
            throw e;
        } catch (Exception e) {
            throw e;
        }

    }
}