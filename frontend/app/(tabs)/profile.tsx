import { Ionicons } from "@expo/vector-icons";
import { useState } from "react";
import { Image, ScrollView, Text, TouchableOpacity, View } from "react-native";

export default function Profile() {
  // States for expandable sections
  const [historyOpen, setHistoryOpen] = useState(false);
  const [workoutsOpen, setWorkoutsOpen] = useState(false);
  const [settingsOpen, setSettingsOpen] = useState(false);
  const [helpOpen, setHelpOpen] = useState(false);

  return (
    <View className="flex-1 bg-[#FBFAFB] rounded-b-[40px]">
      {/* Top Bar */}
      <View className="flex-row justify-between items-center px-6 pt-12 pb-4">
        <TouchableOpacity>
          <Ionicons name="log-out-outline" size={22} color="red" />
        </TouchableOpacity>

        <Text className="text-lg font-bold">Profile</Text>

        <TouchableOpacity onPress={() => setSettingsOpen(!settingsOpen)}>
          <Ionicons name="settings-outline" size={22} color="black" />
        </TouchableOpacity>
      </View>

      <ScrollView
        contentContainerStyle={{ alignItems: "center", paddingTop: 30 }}
      >
        {/* Profile Image */}
        <Image
          source={{
            uri: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQyq1y9naDpRcVvlTdHSusid2SVHsEc8S1PTGu_IG7TeeWzJVMwPPBfXWU&s",
          }}
          className="w-28 h-28 rounded-full mb-4"
        />

        {/* Display Name */}
        <Text className="text-xl font-bold">John Doe</Text>

        {/* Username */}
        <Text className="text-gray-400 mb-8">@johndoe</Text>

        {/* Scanned Machines / My History */}
        <TouchableOpacity
          className="w-[90%] bg-white p-4 rounded-xl mb-2 shadow flex-row justify-between items-center"
          onPress={() => setHistoryOpen(!historyOpen)}
        >
          <Text className="text-gray-800 font-medium">Scanned Machines</Text>
          <Ionicons
            name={historyOpen ? "chevron-up" : "chevron-down"}
            size={20}
            color="gray"
          />
        </TouchableOpacity>
        {historyOpen && (
          <View className="w-[85%] mb-4 pl-4">
            <TouchableOpacity className="p-3">
              <Text>Recently Scanned</Text>
            </TouchableOpacity>
            <TouchableOpacity className="p-3">
              <Text>Favorites</Text>
            </TouchableOpacity>
          </View>
        )}

        {/* My Workouts / Suggestions */}
        <TouchableOpacity
          className="w-[90%] bg-white p-4 rounded-xl mb-2 shadow flex-row justify-between items-center"
          onPress={() => setWorkoutsOpen(!workoutsOpen)}
        >
          <Text className="text-gray-800 font-medium">My Workouts</Text>
          <Ionicons
            name={workoutsOpen ? "chevron-up" : "chevron-down"}
            size={20}
            color="gray"
          />
        </TouchableOpacity>
        {workoutsOpen && (
          <View className="w-[85%] mb-4 pl-4">
            <TouchableOpacity className="p-3">
              <Text>Saved Exercises</Text>
            </TouchableOpacity>
            <TouchableOpacity className="p-3">
              <Text>Custom Plans</Text>
            </TouchableOpacity>
          </View>
        )}

        {/* Settings */}
        {settingsOpen && (
          <View className="w-[90%] bg-white p-4 rounded-xl mb-4 shadow">
            <TouchableOpacity className="p-3">
              <Text>Edit Profile</Text>
            </TouchableOpacity>
            <TouchableOpacity className="p-3">
              <Text>Dark / Light Mode</Text>
            </TouchableOpacity>
          </View>
        )}

        {/* Help & Feedback */}
        <TouchableOpacity
          className="w-[90%] bg-white p-4 rounded-xl mb-2 shadow flex-row justify-between items-center"
          onPress={() => setHelpOpen(!helpOpen)}
        >
          <Text className="text-gray-800 font-medium">Help & Feedback</Text>
          <Ionicons
            name={helpOpen ? "chevron-up" : "chevron-down"}
            size={20}
            color="gray"
          />
        </TouchableOpacity>
        {helpOpen && (
          <View className="w-[85%] mb-4 pl-4">
            <TouchableOpacity className="p-3">
              <Text>FAQs</Text>
            </TouchableOpacity>
            <TouchableOpacity className="p-3">
              <Text>Contact Support</Text>
            </TouchableOpacity>
            <TouchableOpacity className="p-3">
              <Text>App Version</Text>
            </TouchableOpacity>
          </View>
        )}

        {/* Legal */}
        <TouchableOpacity className="w-[90%] bg-white p-4 rounded-xl mb-2 shadow">
          <Text className="text-gray-800 font-medium">Terms of Service</Text>
        </TouchableOpacity>
        <TouchableOpacity className="w-[90%] bg-white p-4 rounded-xl mb-8 shadow">
          <Text className="text-gray-800 font-medium">Privacy Policy</Text>
        </TouchableOpacity>
      </ScrollView>
    </View>
  );
}
