import { Ionicons, MaterialIcons } from "@expo/vector-icons";
import { Tabs } from "expo-router";
import React from "react";

export default function TabLayout() {
  const ICON_SIZE = 24;
  const GREY = "#888";
  const WHITE = "#fff";
  const BG = "#010102";

  return (
    <Tabs
      screenOptions={{
        headerShown: false,
        tabBarStyle: {
          backgroundColor: BG,
          borderTopWidth: 0,
        },
        tabBarActiveTintColor: WHITE,
        tabBarInactiveTintColor: GREY,
        tabBarShowLabel: true,
        tabBarLabelStyle: { fontSize: 8 },
        sceneStyle: { backgroundColor: BG },
      }}
    >
      <Tabs.Screen
        name="home"
        options={{
          title: "Home",
          tabBarIcon: ({ color, focused }) => (
            <Ionicons
              name={focused ? "home" : "home-outline"}
              size={ICON_SIZE}
              color={color}
            />
          ),
        }}
      />
      <Tabs.Screen
        name="ask-ai"
        options={{
          title: "AskAi",
          tabBarIcon: ({ color, focused }) => (
            <MaterialIcons
              name={focused ? "smart-toy" : "smart-toy-outlined"}
              size={ICON_SIZE}
              color={color}
            />
          ),
        }}
      />
      <Tabs.Screen
        name="feature"
        options={{
          title: "Feature",
          tabBarIcon: ({ color, focused }) => (
            <Ionicons
              name={focused ? "rocket" : "rocket-outline"}
              size={ICON_SIZE}
              color={color}
            />
          ),
        }}
      />
      <Tabs.Screen
        name="profile"
        options={{
          title: "Profile",
          tabBarIcon: ({ color, focused }) => (
            <Ionicons
              name={focused ? "person" : "person-outline"}
              size={ICON_SIZE}
              color={color}
            />
          ),
        }}
      />
    </Tabs>
  );
}
