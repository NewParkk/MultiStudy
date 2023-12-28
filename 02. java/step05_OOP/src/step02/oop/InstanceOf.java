/* instanceOf
 * - 문법 : 객체 instanceOf 타입
 * - 결과 : boolean (t / f)
 */
package step02.oop;

class A {}
class B extends A {} 
class C extends A {}

public class InstanceOf {
	public static void main(String[] args) {
		A b = new B();
		A c = new C();
		
		System.out.println(b instanceof A); // t 
		System.out.println(b instanceof B); // t
		System.out.println(b instanceof C); // f
		
		System.out.println();
		
		System.out.println(c instanceof A); // t
		System.out.println(c instanceof B); // f
		System.out.println(c instanceof C); // t
		
		System.out.println();
		
		B b2 = new B();
		System.out.println(b2 instanceof A); // 
		System.out.println(b2 instanceof B); // 
//		System.out.println(b2 instanceof C); //  
		
	}
}