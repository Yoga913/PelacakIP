import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
ip                   : 8.8.8.8
version              : IPv4
city                 : Mountain View
region               : California
region_code          : CA
country              : US
country_name         : United States
country_code         : US
country_code_iso3    : USA
country_capital      : Washington
country_tld          : .us
continent_code       : NA
in_eu                : False
postal               : 94043
latitude             : 37.42301
longitude            : -122.083352
timezone             : America/Los_Angeles
utc_offset           : -0700
country_calling_code : +1
currency             : USD
currency_name        : Dollar
languages            : en-US,es-US,haw,fr
country_area         : 9629091
country_population   : 327167434
asn                  : AS15169
org                  : GOOGLE
*/

@JsonIgnoreProperties(ignoreUnknown = true)
public class ipObject {

	public String ip;
	public String version;
	public String city;
	public String region;
	public String region_code;
	public String country;
	public String country_name;
	public String country_code;
	public String country_code_iso3;
	public String country_capital;
	public String country_tld;
	public String continent_code;
	public String in_eu;
	public String postal;
	public String latitude;
	public String longitude;
	public String timezone;
	public String utc_offset;
	public String country_calling_code;
	public String currency;
	public String currency_name;
	public String languages;
	public String country_area;
	public String country_population;
	public String asn;
	public String org;

	public ipObject() {
		
		
	
	}
	
	
	
	
	
	
	
	
	
	
	
	public String getIp() {
		return ip;
	}











	public String getVersion() {
		return version;
	}











	public String getCity() {
		return city;
	}











	public String getRegion() {
		return region;
	}











	public String getRegion_code() {
		return region_code;
	}











	public String getCountry() {
		return country;
	}











	public String getCountry_name() {
		return country_name;
	}











	public String getCountry_code() {
		return country_code;
	}











	public String getCountry_code_iso3() {
		return country_code_iso3;
	}











	public String getCountry_capital() {
		return country_capital;
	}











	public String getCountry_tld() {
		return country_tld;
	}











	public String getContinent_code() {
		return continent_code;
	}











	public String getIn_eu() {
		return in_eu;
	}











	public String getPostal() {
		return postal;
	}











	public String getLatitude() {
		return latitude;
	}











	public String getLongitude() {
		return longitude;
	}











	public String getTimezone() {
		return timezone;
	}











	public String getUtc_offset() {
		return utc_offset;
	}











	public String getCountry_calling_code() {
		return country_calling_code;
	}











	public String getCurrency() {
		return currency;
	}











	public String getCurrency_name() {
		return currency_name;
	}











	public String getLanguages() {
		return languages;
	}











	public String getCountry_area() {
		return country_area;
	}











	public String getCountry_population() {
		return country_population;
	}











	public String getAsn() {
		return asn;
	}











	public String getOrg() {
		return org;
	}









	//"<html><font color=\"red\">"+country+"</font></html>"

	public String GetObjectValue() {
		
		String vals =			
"Alamat IP:               "+                             ip                    +"\n"+ 
"Versi  IP:               "+				 version               +"\n"+         
"Kota:                    "+				 city       +          "\n"+   
"Wilayah:                 "+				 region      +         "\n"+   
"Kode Wilayah:            "+				 region_code  +        "\n"+   
"Negara:                  "+				 country       +       "\n"+   
"Nama Negara:             "+				 country_name   +      "\n"+   
"Kode Negara :            "+				 country_code    +     "\n"+   
"Kode Negara ISO:         "+				 country_code_iso3+    "\n"+   
"Ibukota Negara:          "+				 country_capital   +   "\n"+   
"Tld Negara:              "+				 country_tld        +  "\n"+   
"Kode Benua:              "+				 continent_code      + "\n"+   
"In EU?:                  "+				 in_eu                +"\n"+   
"Kode Pos:                "+				 postal               +"\n"+
"Lintang:                 "+				 latitude             +"\n"+   
"Bujur:                   "+				 longitude            +"\n"+   
"Zona Waktu:              "+				 timezone             +"\n"+   
"Offerset UTC:            "+				 utc_offset           +"\n"+   
"Code Panggilan Negara:   "+				 country_calling_code +"\n"+   
"Mata Uang:               "+				 currency             +"\n"+   
"Nama Mata Uang:          "+				 currency_name      +"\n"+   
"Bahasa:                  "+				 languages           +"\n"+   
"Luas negara:             "+				 country_area        +"\n"+   
"Populasi Negara:         "+				 country_population   +"\n"+   
"IP ASN:                  "+				 asn                  +"\n"+   
"Organisasi:              "+				 org                  
				
				
				; return vals;
		
	}
	
}

/* 
 * Berikut adalah penjelasan mengenai setiap bagian dari kode program Java yang diberikan beserta alurnya:

### Import Statement
```java
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
```
Kode ini mengimpor anotasi `JsonIgnoreProperties` dari pustaka Jackson. Anotasi ini digunakan untuk mengabaikan properti yang tidak dikenali saat proses deserialisasi JSON menjadi objek Java.

### Class Declaration and Annotations
```java
@JsonIgnoreProperties(ignoreUnknown = true)
public class ipObject {
```
Anotasi `@JsonIgnoreProperties(ignoreUnknown = true)` digunakan di sini untuk menginstruksikan Jackson agar mengabaikan properti yang tidak dikenali dalam JSON ketika memetakan ke objek `ipObject`. Hal ini penting untuk menjaga agar proses deserialisasi tidak gagal jika JSON memiliki properti tambahan yang tidak didefinisikan dalam kelas.

### Properties
```java
    public String ip;
    public String version;
    public String city;
    public String region;
    public String region_code;
    public String country;
    public String country_name;
    public String country_code;
    public String country_code_iso3;
    public String country_capital;
    public String country_tld;
    public String continent_code;
    public String in_eu;
    public String postal;
    public String latitude;
    public String longitude;
    public String timezone;
    public String utc_offset;
    public String country_calling_code;
    public String currency;
    public String currency_name;
    public String languages;
    public String country_area;
    public String country_population;
    public String asn;
    public String org;
```
Properti-properti di atas merepresentasikan berbagai informasi terkait sebuah alamat IP, seperti alamat IP itu sendiri, versi IP, lokasi geografis, informasi negara, dan lain-lain. Semua properti ini bertipe `String`.

### Constructor
```java
    public ipObject() {
        // Constructor kosong
    }
```
Konstruktor kosong ini diperlukan agar kelas `ipObject` dapat dibuat tanpa harus memberikan nilai awal untuk semua properti. Ini adalah praktik umum ketika bekerja dengan pustaka deserialisasi seperti Jackson.

### Getter Methods
```java
    public String getIp() { return ip; }
    public String getVersion() { return version; }
    public String getCity() { return city; }
    public String getRegion() { return region; }
    public String getRegion_code() { return region_code; }
    public String getCountry() { return country; }
    public String getCountry_name() { return country_name; }
    public String getCountry_code() { return country_code; }
    public String getCountry_code_iso3() { return country_code_iso3; }
    public String getCountry_capital() { return country_capital; }
    public String getCountry_tld() { return country_tld; }
    public String getContinent_code() { return continent_code; }
    public String getIn_eu() { return in_eu; }
    public String getPostal() { return postal; }
    public String getLatitude() { return latitude; }
    public String getLongitude() { return longitude; }
    public String getTimezone() { return timezone; }
    public String getUtc_offset() { return utc_offset; }
    public String getCountry_calling_code() { return country_calling_code; }
    public String getCurrency() { return currency; }
    public String getCurrency_name() { return currency_name; }
    public String getLanguages() { return languages; }
    public String getCountry_area() { return country_area; }
    public String getCountry_population() { return country_population; }
    public String getAsn() { return asn; }
    public String getOrg() { return org; }
```
Metode-metode getter ini digunakan untuk mengakses nilai dari properti-properti dalam objek `ipObject`. Setiap metode mengembalikan nilai dari properti yang sesuai.

### Method to Get Object Values
```java
    public String GetObjectValue() {
        String vals = 
            "Alamat IP:               " + ip + "\n" + 
            "Versi  IP:               " + version + "\n" + 
            "Kota:                    " + city + "\n" + 
            "Wilayah:                 " + region + "\n" + 
            "Kode Wilayah:            " + region_code + "\n" + 
            "Negara:                  " + country + "\n" + 
            "Nama Negara:             " + country_name + "\n" + 
            "Kode Negara :            " + country_code + "\n" + 
            "Kode Negara ISO:         " + country_code_iso3 + "\n" + 
            "Ibukota Negara:          " + country_capital + "\n" + 
            "Tld Negara:              " + country_tld + "\n" + 
            "Kode Benua:              " + continent_code + "\n" + 
            "In EU?:                  " + in_eu + "\n" + 
            "Kode Pos:                " + postal + "\n" + 
            "Lintang:                 " + latitude + "\n" + 
            "Bujur:                   " + longitude + "\n" + 
            "Zona Waktu:              " + timezone + "\n" + 
            "Offerset UTC:            " + utc_offset + "\n" + 
            "Code Panggilan Negara:   " + country_calling_code + "\n" + 
            "Mata Uang:               " + currency + "\n" + 
            "Nama Mata Uang:          " + currency_name + "\n" + 
            "Bahasa:                  " + languages + "\n" + 
            "Luas negara:             " + country_area + "\n" + 
            "Populasi Negara:         " + country_population + "\n" + 
            "IP ASN:                  " + asn + "\n" + 
            "Organisasi:              " + org;
        
        return vals;
    }
```
Metode `GetObjectValue()` ini menggabungkan nilai-nilai dari semua properti dalam objek `ipObject` ke dalam sebuah `String` yang diformat dengan baik. Setiap properti dipisahkan oleh baris baru (`\n`), dan hasilnya adalah representasi tekstual dari objek `ipObject` dengan semua informasi yang terkait.

### Alur Program
1. **Deklarasi dan Anotasi**: Kelas `ipObject` dideklarasikan dan dianotasi dengan `@JsonIgnoreProperties(ignoreUnknown = true)` untuk mengabaikan properti yang tidak dikenali saat deserialisasi.
2. **Deklarasi Properti**: Semua properti yang diperlukan dideklarasikan sebagai `public String`.
3. **Konstruktor Kosong**: Konstruktor kosong didefinisikan untuk memungkinkan pembuatan objek tanpa nilai awal.
4. **Metode Getter**: Metode getter didefinisikan untuk setiap properti untuk mengakses nilainya.
5. **Metode `GetObjectValue()`**: Metode ini menggabungkan semua nilai properti menjadi satu `String` yang diformat dan mengembalikannya.

Dengan penjelasan ini, setiap bagian dari kode dan alurnya dapat dipahami dengan jelas.
 */