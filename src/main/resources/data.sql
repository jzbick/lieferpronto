INSERT INTO address
VALUES ('9800aba6-4e1c-4f94-a694-64aa9b0090b6', 'Dortmund', 'Märkische Str. 137', '44141');
INSERT INTO address
VALUES ('05117291-7610-45ba-a332-41420ab55a1f', 'Dortmund', 'Gutenbergstraße 33', '44139');
INSERT INTO address
VALUES ('be416398-70ca-4335-bea9-3fcaa6733b71', 'Dortmund', 'Rheinlanddamm 8', '44139');
INSERT INTO address
VALUES ('04b08a4a-3734-4d24-9af4-e3fafbf845bb', 'Dortmund', 'Willem-van-Vloten-Straße 4', '44263');
INSERT INTO address
VALUES ('0884fe3e-fe72-4f3d-a232-32f467f4acd5', 'Dortmund', 'Hafenpromenade 1-2', '44263');

INSERT INTO restaurant
VALUES ('99630e9b-850e-42c1-9062-2388f962e5ca', 2.50, 'fanzy@delivery.com', 20, 'Fanzy', '1234qwer', 'fanzy',
        '9800aba6-4e1c-4f94-a694-64aa9b0090b6');
INSERT INTO restaurant
VALUES ('4b341679-9c7b-441d-990a-49aaf78bba64', 2.50, 'mexitalia@delivery.com', 20, 'Mexitalia', '1234qwer',
        'mexitalia', '05117291-7610-45ba-a332-41420ab55a1f');
INSERT INTO restaurant
VALUES ('ad5d81c5-0747-47d8-adaf-010b9edbaf92', 2.50, 'pottsalat@delivery.com', 20, 'Pottsalat', '1234qwer',
        'pottsalat', 'be416398-70ca-4335-bea9-3fcaa6733b71');
INSERT INTO restaurant
VALUES ('5ca8100c-1d68-4261-973e-537c48177378', 2.50, 'cheesy@delivery.com', 20, 'Cheesy', '1234qwer', 'cheesy',
        '04b08a4a-3734-4d24-9af4-e3fafbf845bb');
INSERT INTO restaurant
VALUES ('f74033c2-09b0-44f8-bea0-ba7b748c604e', 2.50, 'pfefferkorn@delivery.com', 20, 'Pfefferkorn NY Steakhouse',
        '1234qwer', 'pfefferkorn-ny-steakhouse', '0884fe3e-fe72-4f3d-a232-32f467f4acd5');

INSERT INTO dish
VALUES ('9c555272-7cc1-4422-89b5-358f53b7c4f0', 'Gebratene Nudeln mit knuspriger Ente', 8.70,
        '99630e9b-850e-42c1-9062-2388f962e5ca');
INSERT INTO dish
VALUES ('18b234b4-1fa6-4b45-81be-bd539cbbb9e4', 'Gebratene Nudeln mit knusprigem Hähnchen', 7.90,
        '99630e9b-850e-42c1-9062-2388f962e5ca');
INSERT INTO dish
VALUES ('17b46942-1a1b-42d0-a290-ae7cbd627f6a', 'Gebratener Reis mit knuspriger Ente', 8.70,
        '99630e9b-850e-42c1-9062-2388f962e5ca');
INSERT INTO dish
VALUES ('7e50fd89-b970-4332-b9e3-5aaf6abd3f39', 'Gebratener Reis mit knusprigem Hähnchen', 7.90,
        '99630e9b-850e-42c1-9062-2388f962e5ca');
INSERT INTO dish
VALUES ('4d7573dd-fd62-4cdd-88d0-16b896c537ec', 'Hühnersuppe', 3.00, '99630e9b-850e-42c1-9062-2388f962e5ca');

INSERT INTO dish
VALUES ('9c555272-7cc1-4422-89b5-358f53b7c4f1', 'Salat Mista', 4.90, '4b341679-9c7b-441d-990a-49aaf78bba64');
INSERT INTO dish
VALUES ('18b234b4-1fa6-4b45-81be-bd539cbbb9e5', 'Salat Mariana', 5.50, '4b341679-9c7b-441d-990a-49aaf78bba64');
INSERT INTO dish
VALUES ('17b46942-1a1b-42d0-a290-ae7cbd627f6b', 'Pizza Margherita', 4.20, '4b341679-9c7b-441d-990a-49aaf78bba64');
INSERT INTO dish
VALUES ('7e50fd89-b970-4332-b9e3-5aaf6abd3f30', 'Pizza Diavolo', 5.10, '4b341679-9c7b-441d-990a-49aaf78bba64');
INSERT INTO dish
VALUES ('4d7573dd-fd62-4cdd-88d0-16b896c537ed', 'Pasta Napoli', 5.00, '4b341679-9c7b-441d-990a-49aaf78bba64');

INSERT INTO dish
VALUES ('9c555272-7cc1-4422-89b5-358f53b7c4f2', 'Summer Caesar', 10.90, 'ad5d81c5-0747-47d8-adaf-010b9edbaf92');
INSERT INTO dish
VALUES ('18b234b4-1fa6-4b45-81be-bd539cbbb9e6', 'Melonen Schaluppi', 11.90, 'ad5d81c5-0747-47d8-adaf-010b9edbaf92');
INSERT INTO dish
VALUES ('17b46942-1a1b-42d0-a290-ae7cbd627f6c', 'Burrito Bowl', 10.90, 'ad5d81c5-0747-47d8-adaf-010b9edbaf92');
INSERT INTO dish
VALUES ('7e50fd89-b970-4332-b9e3-5aaf6abd3f31', 'Habibi Bowl', 10.90, 'ad5d81c5-0747-47d8-adaf-010b9edbaf92');
INSERT INTO dish
VALUES ('4d7573dd-fd62-4cdd-88d0-16b896c537ee', 'Rosinenbomber Bowl', 10.90, 'ad5d81c5-0747-47d8-adaf-010b9edbaf92');

INSERT INTO dish
VALUES ('9c555272-7cc1-4422-89b5-358f53b7c4f3', 'Tagliatelle Roma', 7.60, '5ca8100c-1d68-4261-973e-537c48177378');
INSERT INTO dish
VALUES ('18b234b4-1fa6-4b45-81be-bd539cbbb9e7', 'Pizza Tonno', 5.20, '5ca8100c-1d68-4261-973e-537c48177378');
INSERT INTO dish
VALUES ('17b46942-1a1b-42d0-a290-ae7cbd627f6d', 'Pizza Meetlover', 7.60, '5ca8100c-1d68-4261-973e-537c48177378');
INSERT INTO dish
VALUES ('7e50fd89-b970-4332-b9e3-5aaf6abd3f32', 'Salat Verde', 3.00, '5ca8100c-1d68-4261-973e-537c48177378');
INSERT INTO dish
VALUES ('4d7573dd-fd62-4cdd-88d0-16b896c537ef', 'Pasta Mista al Forno', 6.60, '5ca8100c-1d68-4261-973e-537c48177378');

INSERT INTO dish
VALUES ('9c555272-7cc1-4422-89b5-358f53b7c4f4', 'Currywurst', 4.99, 'f74033c2-09b0-44f8-bea0-ba7b748c604e');
INSERT INTO dish
VALUES ('18b234b4-1fa6-4b45-81be-bd539cbbb9e8', 'Schweinegeschnetzeltes', 5.49, 'f74033c2-09b0-44f8-bea0-ba7b748c604e');
INSERT INTO dish
VALUES ('17b46942-1a1b-42d0-a290-ae7cbd627f6e', 'Hähnchenknusperfilet', 5.49, 'f74033c2-09b0-44f8-bea0-ba7b748c604e');
INSERT INTO dish
VALUES ('7e50fd89-b970-4332-b9e3-5aaf6abd3f33', 'Pangasiusfilet', 4.99, 'f74033c2-09b0-44f8-bea0-ba7b748c604e');
INSERT INTO dish
VALUES ('4d7573dd-fd62-4cdd-88d0-16b896c537eg', 'Red Hot Chili Peppers', 4.50, 'f74033c2-09b0-44f8-bea0-ba7b748c604e');






