# PA-PBO Kelompok 1 A'23

NAMA  : Dhea Amalia Putri                         
NIM   : 2309116037

NAMA  : David Sebastian Sutandy                                      
NIM   : 2309116041

NAMA  : Nova Nur Fauziah                                      
NIM   : 2309116043

NAMA  : Nurul Hafizah                        
NIM   : 2309116044

NAMA  : Esra Fernanda Siregar                         
NIM   : 2309116049

__________________________________________________________________________________________________________________________________________________________________________________________________________________




APLIKASI (Akselerasi Pengenalan Lingkungan Kampus Sistem Informasi) adalah sebuah platform yang dirancang untuk mendukung proses pengkaderan tingkat program studi Sistem Informasi. Aplikasi ini melibatkan kepanitiaan dengan berbagai divisi, serta bina damping (bindam) yang berperan sebagai pembimbing bagi mahasiswa baru. Bindam berinteraksi langsung dengan peserta untuk memberikan arahan dan pendampingan dalam menyelesaikan penugasan. Selain itu, bindam juga memberikan penilaian berkala setiap minggu untuk memantau perkembangan peserta. Penilaian ini menjadi indikator penting bagi panitia dalam mengukur keberhasilan kegiatan pengkaderan secara keseluruhan.



________________________________________________________________________________________________________________________________________________________________________________________________________________________


# **PENJELASAN**



## __Flowchart__



### 1. Login



 ![login aplikasi](https://github.com/user-attachments/assets/eeaac2cc-b465-42bd-8fec-b16fb6acbd33)


Aplikasi dimulai dari memasukkan NIM dan password pengguna, kemudian aplikasi akan memeriksa dan menentukan role dari pengguna, setelah itu aplikasi akan berlanjut ke menu sesuai dengan role masing-masing.







### 2. Admin






  #### -CRUD user




  
![pbo admin baru](https://github.com/user-attachments/assets/cbbda8be-79cf-4374-ba0d-431d76f50ccc)





   

Di menu admin ada 3 pilihan yaitu manajemen user, manajemen peserta, dan manajemen penilaian. Pada manajemen user akan muncul tampilan CRUD user dan pengguna dapat memilih menu yang ingin digunakan, pengguna juga dapat menggunakan fitur tambahan dari read yaitu filter untuk user. Setelah selesai menggunakan fitur atau CRUD maka program akan kembali ke menu awal CRUD.









 #### -CRUD Peserta




 
   





  ![admin crud peserta baru](https://github.com/user-attachments/assets/5d07e512-2764-473b-8d44-717733f78cee)

   
Di menu manajemen peserta, admin akan diberi tampilan menu CRUD untuk peserta dan kemudian dapat memilih menu untuk menambahkan data, melihat data, mengubah data, menghapus, melakukan searching, sorting, dan filtering untuk data pesertanya.










#### -Admin Data Penilaian













![admin penillaian baru](https://github.com/user-attachments/assets/adfca566-c326-4010-b512-e7e4e8d61df9)




Pada menu ini admin dapat melihat penilaian danmemfilter penilaian.










### 3. Panitia











  ![panitia menu baru](https://github.com/user-attachments/assets/9cb148b6-fa25-4806-9804-472035b3d00d)

   



Panitia dapat melakukan beberapa fitur pada menu nya seperti yang tertera di gambar.









### 4. Bindam












  
![bindam menu baru](https://github.com/user-attachments/assets/488d869e-bfe3-4545-8d29-0f3c2e120928)






Bindam dapat melakukan beberapa fitur pada menu nya seperti yang tertera di gambar.











## __Activity Diagram__









![PBO Bizagi NEW](https://github.com/user-attachments/assets/519aed5d-e947-4f2a-a242-5c90b41a3072)





Activity Diagram memberikan ilustrasi tentang bagaimana setiap aktivitas dalam sebuah sistem dilakukan, diagram ini membantu dalam memahami alur kerja dari setiap proses dalam aplikasi. Diagram ini membantu menggambarkan alur aktivitas dalam suatu sistem yang melibatkan tiga actor di dalamnya yaitu admin, panitia, dan bindam. 







## __Use Case__











![USE CASE PA PBO 2 drawio](https://github.com/user-attachments/assets/13b6cff4-fb46-4e3f-8409-a51829428cd5)






Use Case Diagram memberikan gambaran visual tentang interaksi antara pengguna dengan sistem. Ini mencakup hal-hal utama yang dapat dilakukan oleh pengguna dan bagaimana sistem akan meresponsnya. Diagram ini menunjukkan tiga aktor yang berinteraksi dengan aplikasi “Sistem Penilaian Peserta APLIKASI”.


________________________________________________________________________________________________________________________________________________________________________________________________________________________________________





# __Fitur Program__










## __Tampilan Login__

Pada halaman login, Memasukkan NIM dan password

![login](https://github.com/user-attachments/assets/f59c81c2-9aee-4f33-8a96-983a201f162b)


## __Menu Admin__

Jika pengguna terdaftar sebagai admin maka akan masuk ke menu admin

![menuAdmin](https://github.com/user-attachments/assets/883f3f26-ba95-411b-ac32-668821258cd3)


## __Menu Panitia__

Jika pengguna terdaftar sebagai panitia maka akan masuk ke menu panitia

![menuPanitia](https://github.com/user-attachments/assets/8eb2cb47-e176-4d70-8190-246bb727cffe)


## __Menu Create Penilaian__

Di menu create penilaian bisa menambahkan nilai untuk sebuah kriteria dan keterangannya

![createPenilaian](https://github.com/user-attachments/assets/b1c9aab9-8bfe-4d22-90bf-80f915ee0fee)


## __Menu Edit Penilaian__

Menu edit penilaian digunakan untuk mengubah data penilaian yang sudah dibuat

![editPenilaian](https://github.com/user-attachments/assets/ffb5d6ee-4b4c-40c4-8f86-2caf879acd15)


## __Menu Tambah Peserta__

Menu tambah peserta digunakan untuk memasukkan data peserta dan menambahkannya

![createPeserta](https://github.com/user-attachments/assets/96022122-b59f-40cd-a645-307bb63579d3)


## __Menu Update Peserta__

Di menu update peserta pengguna bisa memasukkan data baru peserta yang ingin diubah

![editPeserta](https://github.com/user-attachments/assets/b09c4a05-10a8-49b7-9b51-8596c5e187a1)


## __Menu Tambah User__

Menu tambah peserta digunakan untuk membuat data user/panitia

![createUser](https://github.com/user-attachments/assets/fa8a4a16-4aeb-4f5d-b376-ea38a15e0d09)


## __Menu Update User__

Menu update user digunakan untuk mengubah data user/panitia yang ada

![editUser](https://github.com/user-attachments/assets/7b52b1ba-58c5-4f95-8f39-c9e416f18847)


## __Menu Index Peserta__

Di menu index peserta bisa melakukan CRUD dan juga fitur yaitu searching

![indexPeserta](https://github.com/user-attachments/assets/d633f285-1203-4060-8216-23e97ddcff72)


## __Menu Index Panitia__

Di menu index panitia bisa melakukan CRUD dan juga fitur yaitu filter

![indexUser](https://github.com/user-attachments/assets/f901065a-cb9d-4888-97e5-169285a0b2a5)

----------------------------------------------------------------------------------------------------------------



________________________________________________________________________________________________________________________________________________________________________________________________________________________





 

