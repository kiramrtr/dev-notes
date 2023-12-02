public class DecoratorPattern {

  public static void main(String[] args) {
    String data = "Name:JohnDoe;Level:Dangerous";
    DataSourceDecorator encoded = new EncryptionDecorator(
      new FileDataSource("out/decorator-pattern-output.txt")
    );

    encoded.writeData(data);

    DataSource plain = new FileDataSource("out/decorator-pattern-output.txt");

    System.out.println("Input: " + data);
    System.out.println("Encoded: " + plain.readData());
    System.out.println("Decoded: " + encoded.readData());
  }
}

interface DataSource {
  void writeData(String data);
  String readData();
}

class FileDataSource implements DataSource {

  private String name;

  FileDataSource(String name) {
    this.name = name;
  }

  @Override
  public void writeData(String data) {
    // write to file
  }

  @Override
  public String readData() {
    // read from file
    return "";
  }
}

class DataSourceDecorator implements DataSource {

  private DataSource wrapper;

  DataSourceDecorator(DataSource dataSource) {
    this.wrapper = dataSource;
  }

  @Override
  public void writeData(String data) {
    wrapper.writeData(data);
  }

  @Override
  public String readData() {
    return wrapper.readData();
  }
}

class EncryptionDecorator extends DataSourceDecorator {

  EncryptionDecorator(DataSource dataSource) {
    super(dataSource);
  }

  @Override
  public void writeData(String data) {
    super.writeData(encode(data));
  }

  @Override
  public String readData() {
    return decode(super.readData());
  }

  private String encode(String data) {
    // encode
    return data;
  }

  private String decode(String encodedData) {
    // decode
    return encodedData;
  }
}
