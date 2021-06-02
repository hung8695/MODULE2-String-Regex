public class ValidClassnameTest {
    public static void main(String[] args) {
            ValidClassname validClassname=new ValidClassname();
            String[] str1={"C1234G", "P5561L","CDA5454A","C6541Z"};
            for (String regex:str1){
                System.out.println(validClassname.validate(regex));
            }
    }
}
