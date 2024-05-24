# payara-ssl-error
SSCCE for Payara Micro SSL certificate issue. The `cacerts.p12` built into the `MICRO-INF/domain`
folder of `payara-micro-6.2024.5.jar` does not support the GlobalSign GCC R6 AlphaSSL certificate.
The certificate is present in `Payara/nucleus/security/core/src/main/resources/config/cacerts.p12`
but not in `Payara/nucleus/admin/template/src/main/resources/config/cacerts.p12`, both of which
were last updated in commit https://github.com/payara/Payara/commit/be2a564e02f2e1ba9dc760e9305b8b537955b795.

## Start server
```shell
mvn clean install payara-micro:start
```

## Verify error
This request attempts to connect to a server using a GlobalSign GCC R6 AlphaSSL certificate. The endpoint
will respond with the message from an `SSLHandshakeException`.
```shell
curl localhost:8080/payara-ssl-error/demo/error
```

## Verify valid certificate
This request attempts to connect to a server using another SSL certificate. The endpoint will respond "OK".
```shell
curl localhost:8080/payara-ssl-error/demo/ok
```
