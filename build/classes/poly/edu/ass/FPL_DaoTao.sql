﻿CREATE DATABASE FPL_DaoTao

IF OBJECT_ID('Users') IS NOT NULL
    DROP TABLE Users
GO
CREATE TABLE Users
(
    USERNAME       NVARCHAR(50) NOT NULL,
    PASSWORD      NVARCHAR(50) NULL,
    ROLE          NVARCHAR(50) NULL,
    CONSTRAINT PK_USERS PRIMARY KEY (USERNAME),
)


IF OBJECT_ID('Students') IS NOT NULL
    DROP TABLE Students
GO
CREATE TABLE Students
(
    MASV       NVARCHAR(50) NOT NULL,
    HOTEN	   NVARCHAR(50)  NULL,
    EMAIL      NVARCHAR(50)  NULL,
    SODT       NVARCHAR(15)  NULL,
    GIOITINH   BIT NULL,
	DIACHI     NVARCHAR(50)  NULL,
	HINH       NVARCHAR(50)  NULL,
    CONSTRAINT PK_Students PRIMARY KEY (MASV),	
)
IF OBJECT_ID('Grade') IS NOT NULL
    DROP TABLE Grade
GO
CREATE TABLE Grade
(
    ID          INT NOT NULL,
    MASV       NVARCHAR(50)  NULL,
    TIENGANH    INT  NULL,
    TINHOC      INT NULL,
    GDTC        INT NULL,
    CONSTRAINT PK_Grade PRIMARY KEY (ID),
	CONSTRAINT PK_Grade_Students FOREIGN KEY (MASV) REFERENCES Students,
)


SELECT*FROM Students
-----2
IF OBJECT_ID('SP_USERS') IS NOT NULL
    DROP PROC SP_USERS
GO
CREATE PROC SP_USERS
    @USERNAME    NVARCHAR(50),
    @PASSWORD        NVARCHAR(50),
    @ROLE        NVARCHAR(50)
AS
    IF(@USERNAME IS NULL) OR (@PASSWORD IS NULL) OR (@ROLE IS NULL) 
        PRINT N'THIẾU THÔNG TIN ĐẦU VÀO'
    ELSE
        INSERT INTO Users VALUES(@USERNAME,@PASSWORD,@ROLE)
        PRINT N'THÊM THÔNG TIN THÀNH CÔNG'
GO
EXEC SP_USERS N'nguyen huu quang','quang1234',N'Giảng Viên'
EXEC SP_USERS N'hieutt','hieu1234',N'Đào Tạo'
EXEC SP_USERS N'teo','teo1234',N'Giảng Viên'
EXEC SP_USERS N'bui xuan huan ','huan1234',N'Giảng Viên'
EXEC SP_USERS N'ngo ba kha','kha1234',N'Đào Tạo'



IF OBJECT_ID('SP_Students') IS NOT NULL
    DROP PROC SP_Students
GO
CREATE PROC SP_Students
    @MASV        NVARCHAR(50),
    @HOTEN       NVARCHAR(50),
    @EMAIL		 NVARCHAR(50),
	@SODT        NVARCHAR(15),
	@GIOITINH    BIT,
	@DIACHI      NVARCHAR(50),
	@HINH        NVARCHAR(50)
AS
    IF(@MASV IS NULL) OR (@HOTEN IS NULL) OR (@EMAIL IS NULL)OR (@SODT IS NULL) OR (@GIOITINH IS NULL)OR (@DIACHI IS NULL) OR (@HINH IS NULL)
        PRINT N'THIẾU THÔNG TIN ĐẦU VÀO'
    ELSE
        INSERT INTO Students VALUES (@MASV,@HOTEN,@EMAIL,@SODT,@GIOITINH,@DIACHI,@HINH)
        PRINT N'THÊM THÔNG TIN THÀNH CÔNG'
GO
EXEC SP_Students 'SV001',N'NGUYỄN VIỆT ANH','ANHNVPH@GMAIL.COM','0977786253',TRUE,N'HÀ NỘI','LyLX.jpg'
EXEC SP_Students 'SV002',N'NGUYỄN HỮU QUANG','QUANG23H@GMAIL.COM','0353117913',TRUE,N'BẮC NINH','LienLX.jpg'
EXEC SP_Students 'SV003',N'NGUYỄN THỊ HÀ','HA11@GMAIL.COM','0977786253',FALSE,N'BẮC NINH','LanLH.jpg'
EXEC SP_Students 'SV004',N'CAO TUẤN ANH','ANH@GMAIL.COM','08876837456',TRUE,N'HẢI PHÒNG','MinhTB.jpg'
EXEC SP_Students 'SV005',N'NGUYỄN ĐỨC PHƯƠNG','PHUONGPH@GMAIL.COM','03478563478',TRUE,N'THÁI BÌNH','LyLX.jpg'
EXEC SP_Students 'SV006',N'ĐỖ ĐÌNH LĨNH','LINH@GMAIL.COM','0978934753',TRUE,N'BẮC GIANG','MinhTB.jpg'
EXEC SP_Students 'SV007',N'NGUYỄN VŨ PHƯƠNG LINH','LINH@GMAIL.COM','0977786253',FALSE,N'SƠN LA','LanLH.jpg'
EXEC SP_Students 'SV008',N'NGÔ BÁ KHÁ','KHA@GMAIL.COM','01287687345',TRUE,N'BẮC NINH','LyLX.jpg'
EXEC SP_Students 'SV009',N'TRƯƠNG THU TRANG','TRANGPH@GMAIL.COM','08623546732',TRUE,N'HÀ NỘI','LanLH.jpg'
EXEC SP_Students 'SV010',N'BÙI XUÂN HUẤN','HUAN@GMAIL.COM','0988877766',TRUE,N'Hà Nội','LienLX.jpg'
EXEC SP_Students 'SV011',N'CAO TUẤN ANH','ANH@GMAIL.COM','0999888777',TRUE,N'BẮC NINH','diec.jpg'
IF OBJECT_ID('SP_Grade') IS NOT NULL
    DROP PROC SP_Grade
GO
CREATE PROC SP_Grade
    @ID          INT ,
    @MASV       NVARCHAR(50),  
    @TIENGANH    INT  ,
    @TINHOC      INT,
    @GDTC        INT 
AS
    IF(@ID IS NULL) OR (@MASV IS NULL) OR (@TIENGANH IS NULL)OR (@TINHOC IS NULL) OR (@GDTC IS NULL)
        PRINT N'THIẾU THÔNG TIN ĐẦU VÀO'
    ELSE
        INSERT INTO Grade  VALUES (@ID,@MASV,@TIENGANH,@TINHOC,@GDTC)
        PRINT N'THÊM THÔNG TIN THÀNH CÔNG'
GO
EXEC SP_Grade 1,'SV001',9,8,6
EXEC SP_Grade 2,'SV002',5,7,9
EXEC SP_Grade 3,'SV003',9,4,6
EXEC SP_Grade 4,'SV004',8,8,6
EXEC SP_Grade 5,'SV005',7,9,6
EXEC SP_Grade 6,'SV006',5,9,4
EXEC SP_Grade 7,'SV007',9,6,8
EXEC SP_Grade 8,'SV008',6,7,5
EXEC SP_Grade 9,'SV009',5,8,6
EXEC SP_Grade 10,'SV010',8,6,6
EXEC SP_Grade 11,'SV011',9,9,7


select * from Students  


select * from Users


select Students.MASV,Students.HOTEN, Grade.TIENGANH,Grade.TINHOC,Grade.GDTC  from Students join Grade on Students.MASV=Grade.MASV
 

 UPDATE Studens SET HOTEN=quang WHERE MASV='SV012'
 DELETE FROM Students WHERE MASSV = ?


 SELECT TOP 3 Students.MASV, HOTEN, TIENGANH,TINHOC,GDTC,
			(TIENGANH+TINHOC+GDTC)/3 AS DIEMTB FROM Gra