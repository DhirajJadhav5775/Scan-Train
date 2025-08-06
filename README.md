# 🏋️ Scan&Train: AI-Powered Gym Machine Scanner

**Scan&Train** is an intelligent fitness assistant that helps gym-goers identify workout machines using their phone’s camera and instantly provides personalized exercise suggestions. Powered by on-device machine learning and enriched with Google’s Gemini API, Scan&Train makes your fitness journey smarter and easier — no trainer needed.

## ✨ Key Features

- 📸 **Scan-to-Identify**  
  Just point your camera at a gym machine — Scan&Train tells you what it is.

- 🧠 **Smart Exercise Suggestions**  
  Get a list of workouts relevant to the machine (e.g., Chest Press → Incline Press, Cable Fly).

- ⚡ **On-Device Machine Learning**  
  Fast and private predictions using TensorFlow Lite or Google ML Kit.

- 🌐 **Gemini-Powered Insights** (Coming Soon)  
  Contextual workout tips, machine instructions, and safety advice via Gemini API.

- 🔐 **Secure Auth + Backend Support**  
  Backed by Java Spring Boot for scalable machine & user data handling.

## ⚙️ Tech Stack

- **Frontend**: Expo React Native, TypeScript, Nativewind
- **Camera & ML**: Google ML Kit, TensorFlow Lite
- **LLM Integration**: Gemini API (for contextual responses and tips)
- **Backend**: Java Spring Boot
- **Database**: Firebase *(TBD)*
- **Deployment**: Vercel (Frontend), Render / Railway (Backend)

## 🔁 Workflow Overview

User opens app → Scans a gym machine → Image processed via ML model → Identified machine class → Workout suggestions fetched from DB → (Optional) Gemini provides context/tips → User starts training!

## 🚀 Getting Started

> Clone the repo and follow platform-specific setup instructions.

### 1. Clone the repository

```bash
git clone https://github.com/DhirajJadhav5775/Scan-Train.git
cd Scan-Train
```

### 2. Run the frontend

```bash
cd frontend
npm install
npx expo start
```

### 3. Run the backend (Spring Boot)

```bash
cd backend
./mvnw spring-boot:run
```

## 📌 Roadmap

* [x] Initial UI with camera integration

* [x] Basic on-device image classification

* [ ] Backend API with Spring Boot

* [ ] Gemini API integration for workout tips

* [ ] Dataset expansion (20–30+ gym machines)

* [ ] Exercise database with images and descriptions

* [ ] Offline support

* [ ] Voice assistant integration

## 👥 Team

This project is being crafted with 💪 by:

* **Dhiraj Jadhav** – [@DhirajJadhav5775](https://github.com/DhirajJadhav5775)
  *Backend, Spring Boot Integrations, ML Integrations*

* **Mohd Aqdas Asim** – [@MohdAqdasAsim](https://github.com/MohdAqdasAsim)
  *Frontend & UI/UX, ML Integrations*

## 📄 License

This project is licensed under the [MIT License](LICENSE).


## 🙌 Contributions

Want to help improve machine detection or add workouts?
Feel free to fork, open an issue, or submit a PR.
Let’s build the future of fitness tech — one scan at a time.

> “Know your machine. Own your workout.” – Scan&Train