public class BuilderPattern {

  public static void main(String[] args) {
    Modal infoModal = new Modal.Builder()
      .setContent("This is simple info modal")
      .setConfirmButton("Ok")
      .build();

    System.out.println(infoModal);

    Modal normalModal = new Modal.Builder()
      .setHeading("Create User")
      .setContent("Fields required for creating user")
      .setConfirmButton("Create User")
      .setCancelButton("Cancel")
      .build();

    System.out.println(normalModal);
  }
}

class Modal {

  private String heading;
  private String content;
  private String confirmButton;
  private String cancelButton;

  private Modal(
    String heading,
    String content,
    String confirmButton,
    String cancelButton
  ) {
    this.heading = heading;
    this.content = content;
    this.confirmButton = confirmButton;
    this.cancelButton = cancelButton;
  }

  @Override
  public String toString() {
    return String.format(
      "%s %n %s%n %s    %s",
      heading,
      content,
      confirmButton,
      cancelButton
    );
  }

  static class Builder {

    private String heading;
    private String content;
    private String confirmButton;
    private String cancelButton;

    Builder() {}

    Builder setHeading(String heading) {
      this.heading = heading;
      return this;
    }

    Builder setContent(String content) {
      this.content = content;
      return this;
    }

    Builder setConfirmButton(String confirmButton) {
      this.confirmButton = confirmButton;
      return this;
    }

    Builder setCancelButton(String cancelButton) {
      this.cancelButton = cancelButton;
      return this;
    }

    Modal build() {
      return new Modal(heading, content, confirmButton, cancelButton);
    }
  }
}
