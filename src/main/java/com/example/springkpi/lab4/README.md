**Request examples:**

_GET_

```
http://localhost:8080/currencies 

http://localhost:8080/rates 

http://localhost:8080/rates/currency?code=U&startDate=2024-11-01&endDate=2024-11-08
```

_POST_

```
http://localhost:8080/currencies/add?id=1&name=US_Dollar&code=USD

http://localhost:8080/rates/addByDayAndCode?currencyCode=U&date=2024-11-05&rate=128.55
```

_PUT_

```
http://localhost:8080/currencies/1
```

_DELETE_

```
http://localhost:8080/currencies/1
```