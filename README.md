# Airlines-Ticketing-System-Backend-Service-Application

## Havayolları Biletleme Sistemi Backend Servis Uygulaması
## Teknolojiler:

JAVA 17,
Maven,
Spring Boot 3,
MySQL Database,
Restful Web Service (JSON),
## Gereksinimler:

1. Havayolu şirketi eklenebiliyor ve aranabiliyor.
2. Havaalanı eklenebiliyor ve aranabiliyor.
3. Rota eklenebiliyor ve aranabiliyor.
4. Havayolu şirketine uçuş tanımlanabiliyor ve aranabiliyor.
5. Bilet satın alınabiliyor:
   Satın alma işlemi sırasında kredi kartı bilgileri maskeleniyor. (Örneğin "4221161122330005" -> "422116******0005").
   Kredi kartı numarasının aralarında boşluklar ya da ayraçlar olması gibi durumları da kapsayacak şekilde geliştirme yapılıyor. Örneğin; 
   Request’te kart numarası farklı formatlarda da gelse (Örnek: "4221-1611-2233-0005", "4221,1611,2233,0005"), kart bilgisi beklenen şekilde ("422116******0005") maskelenerek satın alma işlemine alınıyor.
6. Bilet numarası ile arama yapılabiliyor ve bilet iptali yapılabiliyor.
7. Silme gerektiren işlemlerde soft delete yapılıyor.
8. Global Exception Handling yapısı kuruluyor.
9. API response’ları ortak bir yapı üzerinden dönülüyor.

--------------------------------------------------------------------------------------------------

## Airlines Ticketing System Backend Service Application
## Technologies

JAVA 17,
Maven,
Spring Boot 3,
MySQL Database,
Restful Web Service (JSON),
## Requirements:

1. Airline can be added and searched.
2. Airport can be added and searched.
3. Route can be added and searched.
4. The flight to the airline can be defined and searched.
5. Tickets can be purchased:
   Credit card information is masked during the purchase process (e.g. "4221161122330005" -> "422116******0005").
   Improvements are also being made to cover situations such as spaces or brackets between the credit card number. For example; 
   Even if the card number comes in different formats in the request (Example: "4221-1611-2233-0005", "4221,1611,2233,0005"), the card information is masked as expected ("422116******0005") and taken into the purchase process.
6. Ticket number can be used to search and cancel tickets.
7. Soft delete is performed in transactions that require deletion.
8. Global Exception Handling structure is established.
9. API responses are returned through a common structure.

