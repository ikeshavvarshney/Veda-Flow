# Veda Flow

Veda Flow is a cultural and religious networking platform built with React and Node.js, designed to spread awareness, foster communities, and organize events. Inspired by LinkedIn’s structure, it allows users to share posts, join communities, and explore cultural knowledge with AI-powered summaries.

---

## 🚀 Features

* **Authentication**: Signup & login system.
* **User Profiles**: Create and customize your profile.
* **Posts Feed**: Share, upvote, downvote, and interact with cultural posts.
* **Search**: Find users, communities, and cultural content.
* **Add Post**: Contribute posts, blogs, or announcements.
* **Communities**: Create or join communities, spread awareness, and host events.
* **AI Summaries**: Auto-generate short summaries for posts, profiles, and events.

---

## 📂 Project Structure

```
veda-flow/
│
├── frontend/   # React-based frontend
│   ├── src/
│   └── ...
│
├── backend/    # Node.js + Express backend
│   ├── models/
│   ├── routes/
│   └── ...
│
└── README.md   # Documentation
```

---

## 🛠️ Tech Stack

* **Frontend**: React, TailwindCSS, shadcn/ui, Axios
* **Backend**: Node.js, Express, MongoDB
* **Authentication**: JWT-based auth
* **AI Features**: OpenAI API (for summaries)

---

## ⚙️ Installation

1. Clone the repository:

```bash
git clone https://github.com/yourusername/veda-flow.git
cd veda-flow
```

2. Install dependencies for frontend & backend:

```bash
cd frontend && npm install
cd ../backend && npm install
```

3. Setup environment variables in both frontend and backend:

* **Backend**: `.env` file with `MONGO_URI`, `JWT_SECRET`, `OPENAI_API_KEY`
* **Frontend**: `.env` file with API base URL

4. Run the backend server:

```bash
cd backend
npm start
```

5. Run the frontend:

```bash
cd frontend
npm start
```

---

## 📌 Usage

1. Open `http://localhost:3000` in your browser.
2. Sign up or log in.
3. Create your profile.
4. Explore posts, join communities, and share cultural knowledge.

---

## 🤝 Contributing

1. Fork the repo
2. Create a new branch (`feature-xyz`)
3. Commit changes
4. Push to your fork and submit a PR

---

## 📜 License

MIT License © 2025 Veda Flow
