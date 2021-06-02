public class ValidNumberPhoneTest {
    public static void main(String[] args) {
        ValidNumberPhone validNumberPhone=new ValidNumberPhone();
        String[] hihi={"33-35593833","01-23456789","54-455454555454"};
        for (String regex:hihi){
            System.out.println(validNumberPhone.validate(regex));
        }
    }
}
