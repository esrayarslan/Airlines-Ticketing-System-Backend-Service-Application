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

