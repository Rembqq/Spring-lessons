**Request examples:**

_GET_

```
http://localhost:8080/currencies 

http://localhost:8080/rates 
```

_POST_

```
http://localhost:8080/currencies/add?role=admin&id=1&name=US_Dollar&code=USD

http://localhost:8080/rates/addRate?role=admin&currencyCode=USD&date=2024-11-01&rate=28.35
```