// import { useFirstLaunch } from "@/hooks/useFirstLaunch";
// import { useRouter } from "expo-router";
// import React, { useEffect } from "react";
import { ActivityIndicator, View } from "react-native";
import "../global.css";
import OnBoarding from "./pages/misc/on-boarding";

const App = () => {
  // const isFirstLaunch = useFirstLaunch();
  const isFirstLaunch = true;
  // const router = useRouter();

  // useEffect(() => {
  //   if (isFirstLaunch === false) {
  //     requestAnimationFrame(() => {
  //       router.replace("/home");
  //     });
  //   }
  // }, [isFirstLaunch]);

  if (isFirstLaunch === null) {
    return (
      <View className="flex-1">
        <ActivityIndicator size="large" color="#513d73" />
      </View>
    );
  }

  if (isFirstLaunch) {
    return <OnBoarding />;
  }

  return null;
};

export default App;
