public class SingletonWithEnum {

  public static void main(String[] args) {
    System.out.println(Resource.INSTANCE.getData());
    System.out.println(Resource.INSTANCE.getData());
  }
}

enum Resource {
  INSTANCE;

  private final String data;

  Resource() {
    data = "singleton data";
    System.out.println("Initialized Resource");
  }

  public String getData() {
    return data;
  }
}
