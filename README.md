# Airlines-Ticketing-System-Backend-Service-Application

Havayolları Biletleme Sistemi Backend Servis Uygulaması
Teknolojiler:

JAVA 17
Maven
Spring Boot 3
MySQL Database
Restful Web Service (JSON)
Gereksinimler:

Havayolu şirketi eklenebiliyor ve aranabiliyor.
Havaalanı eklenebiliyor ve aranabiliyor.
Rota eklenebiliyor ve aranabiliyor.
Havayolu şirketine uçuş tanımlanabiliyor ve aranabiliyor.
Bilet satın alınabiliyor:
Satın alma işlemi sırasında kredi kartı bilgileri maskeleniyor. (Örneğin "4221161122330005" -> "422116******0005").
Kredi kartı numarasının aralarında boşluklar ya da ayraçlar olması gibi durumları da kapsayacak şekilde geliştirme yapılıyor. Örneğin; Request’te kart numarası farklı formatlarda da gelse (Örnek: "4221-1611-2233-0005", "4221,1611,2233,0005"), kart bilgisi beklenen şekilde ("422116******0005") maskelenerek satın alma işlemine alınıyor.
Bilet numarası ile arama yapılabiliyor ve bilet iptali yapılabiliyor.
Silme gerektiren işlemlerde soft delete yapılıyor.
Global Exception Handling yapısı kuruluyor.
API response’ları ortak bir yapı üzerinden dönülüyor.

