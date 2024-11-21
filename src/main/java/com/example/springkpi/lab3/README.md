**Request examples:**

_GET_

```
http://localhost:8080/currencies 

http://localhost:8080/rates 

http://localhost:8080/rates/currency?role=admin&code=U&startDate=2024-11-01&endDate=2024-11-08
```

_POST_

```
http://localhost:8080/currencies/add?role=admin&id=1&name=US_Dollar&code=USD

http://localhost:8080/currencies/edit/1?role=admin&name=US_Dol

http://localhost:8080/rates/addByDayAndCode?role=admin&currencyCode=U&date=2024-11-05&rate=128.55

http://localhost:8080/currencies/delete/1?role=admin
```