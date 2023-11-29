# Singleton

## Eager initialization

```{code-block} java
:linenos:
:emphasize-lines: 2

class Resource {
  private static final Resource INSTANCE = new Resource();

  private Resource() {}

  public static Resource getInstance() {
    return INSTANCE;
  }
}
```

## Lazy initialization

### Double checked locking

```{code-block} java
:linenos:
:emphasize-lines: 2,6,7,9,10

public class Resource {
  private volatile Resource instance = null;

  private Resource() {}

  public static Resource getInstance() {
    if (instance == null) { // First check
      synchronized (this) {
        if (instance == null) { // Second check
          instance = new Instance();
        }
      }
    }
    return instance;
  }
}
```

### Concise

```{code-block} java
:linenos:
:emphasize-lines: 4-6,8-10

public class Resource {
  private Resource() {}

  private static class Holder {
    static final Resource INSTANCE = new Resource();
  }

  public static Resource getInstance() {
    return Holder.INSTANCE;
  }
}
```

On calling `Holder.INSTANCE` only creates resource using `new Resource()`.

### Enum

```{code-block} java
:linenos:

enum Resource {
  INSTANCE;

  Resource() {}
}
```
