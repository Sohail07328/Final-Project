# 📘 Insurance Automation Project

## 📌 Project Overview
This project automates workflows for various insurance modules—**Travel**, **Car**, and **Health**—on the **PolicyBazaar** platform using Selenium. It replicates user interactions and extracts real-time data for validation and analysis.

---

## 🎯 Objectives
- Automate workflows across Travel, Car, and Health insurance modules.
- Extract real-time data such as quotes, menus, and error messages.
- Implement error validation through negative testing.
- Showcase form-filling, data extraction, and error capture.

---

## 🛠️ Tools & Technologies Used
- **Selenium WebDriver** – Automation tool  
- **Java** – Primary programming language  
- **TestNG** – Testing framework  
- **Maven** – Build tool  
- **Page Object Model** – Design pattern  
- **Cucumber (Gherkins)** – BDD framework

---

## 🧱 Architecture

### 🔹 Project Object Model
- `base/` – Browser setup  
- `main/` – Logic & page classes (Travel, Car, Health)  
- `testing/` – Test cases  
- `resources/` – XML data files  

### 🔹 Page Object Model
Each page is encapsulated as a Java class:
- `TravelInsurance_Page.java`  
- `CarInsurance_Page.java`  
- `MedicalInsurancePage.java`  

Benefits: Maintainability, Readability, Reusability

---

## 📚 Use Cases

### 1️⃣ Student Travel Insurance
- Fill dummy details (Age 22 & 21) traveling to Europe  
- Scrape 3 cheapest international plans  
- Capture plan names, providers, and premium amounts  

### 2️⃣ Car Insurance Quote Validation
- Attempt quote without car number  
- Enter invalid email/phone  
- Capture error/validation messages  

### 3️⃣ Health Insurance Menu Extraction
- Navigate to Health section  
- Extract visible menu items including plan categories and submenus  

---

## 📊 Output & Demo
- Travel insurance form-fill and scraping plans  
- Car insurance error capture  
- Health insurance menu extraction  
- Outputs include JSON logs, screenshots, and validation logs  

---

## 👥 Contributors
- Raza Kashif  
- Ankit Sahani  
- Ankur Roy  
- Kaushik A.S  
- Mohammad Sohail  
