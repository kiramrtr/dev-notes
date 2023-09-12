# cURL

> Trivia: cURL stands for "Client for URL"

Just noting down the ways of CURL, mostly which I have used.

Flags and their descriptions:

| Flag                          | Description                                            |
| ----------------------------- | ------------------------------------------------------ |
| `-l` `--location`             | Follow redirects                                       |
| `-O`                          | Save file with original filename                       |
| `-o <name>` `--output <name>` | Output's the output to `<name>`                        |
| `-k` `--insecure`             | Ignore SSL errors                                      |
| `-s` `--silent`               | Silent mode for suppressing progress or error messages |

## How to's

### Download file

```
curl --location <url> --output <file-name>
```

Short form for `--location` is `-l` and `--output` is `-o`
