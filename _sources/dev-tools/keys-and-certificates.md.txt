# Keys and Certificates

- X.509 Certificate
- CSR - Certificate Signing Request
- RSA Public Key
- RSA Private Key

Extensions

- cer
- crt
- key
- pem

Encoding Schemes

- PEM - Privacy Enhanced Mail (Base64), can be viewed in any text editor.
- DER (binary).

Container Formats

- PKCS#7
- PKCS#12

Ref:

- https://www.ssl.com/guide/pem-der-crt-and-cer-x-509-encodings-and-conversions/

## PEM

PEM (originally "Privacy Enhanced Mail")

```
-----BEGIN CERTIFICATE-----
<Content>
-----END CERTIFICATE-----
```

**View contents**

```
openssl x509 -in <pem-file> -text -noout
```

Convert PEM to DER

```shell
openssl x509 -in <pem-file> -outform der -out <der-file>
```

**See Certificate details:**

```shell
openssl x509 -noout -text -in 'cerfile.cer'
```

`-inform pem` default in-form, for binary files pass `-inform der`

**Create a RSA key pair and certificate**

```shell
# generate private key of key size 2048
openssl genrsa -out rsa-private-key.pem 2048

# generate public key for given private key
openssl rsa -in rsa-private-key.pem -pubout -out rsa-public-key.pem

# generate certificate from the private key which lasts for 3650 days
openssl req -new -x509 -key rsa-private-key.pem -out mt-app-dev-key.pem -days 3650

# view the certificate details
openssl x509 -noout -text -in mt-app-dev-key.pem | less
```
