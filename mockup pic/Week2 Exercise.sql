/*1*/
SELECT DISTINCT S.sname
FROM Student S, Enrolled E
WHERE s.syear = 'JR' AND S.snum = E.snum AND E.cname IN (
SELECT C.CNAME
FROM Class C, Faculty F
WHERE C.fid = F.fid AND F.fname = 'Newton Totten');

/*2*/
SELECT MAX(S.age)
FROM Student S, Enrolled E
WHERE S.major = 'EE' OR (S.snum = E.snum AND E.canme IN(
SELECT C.cname
FROM Class C, Faculty F
WHERE C.fid = F.fid AND F.fname = 'Newton Totten'));

/*3*/
SELECT DISTINCT C.CNAME
FROM Class C
WHERE C.room = 'R128' OR C.cname IN (
SELECT E.cname
FROM Enrolled E
GROUP BY E.cname
HAVING COUNT(*) >= 5);

/*4*/
SELECT S.sname
FROM Student S, Enrolled E1, Enrolled E2, Class C1, Class C2
WHERE S.snum = E1.snum AND S.snum = E2.snum AND E1.cname <> E2.cname AND C1.cname = E1.cname AND C2.cname = E2.cname AND C1.meets_at = C2.meets_at;

/*5*/
SELECT DISTINCT F.fname
FROM Faculty F, Class C
WHERE 

/*6*/
SELECT F.fname
FROM Faculty F
WHERE (SELECT COUNT(E.snum)
FROM Enrolled E, Class C
WHERE F.fid = C.fid AND C.cname = E.cname)<25;
