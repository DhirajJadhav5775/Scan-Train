/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./App.{js,jsx,ts,tsx}",
    "./app/**/*.{js,jsx,ts,tsx}",
    "./components/**/*.{js,jsx,ts,tsx}",
    "./app/pages/**/*.{js,jsx,ts,tsx}",
    "./app/(tabs)/index.tsx",
  ],
  presets: [require("nativewind/preset")],
  theme: {
    extend: {
      fontFamily: {
        heartful: ["Heartful", "sans-serif"],
      },
    },
  },
  plugins: [],
};
