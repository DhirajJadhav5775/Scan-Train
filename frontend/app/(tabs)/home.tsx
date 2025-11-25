import { Ionicons } from "@expo/vector-icons";
import { Text, TouchableOpacity, View } from "react-native";

export default function Home() {
  return (
    <View className="flex-1 bg-[#FBFAFB] rounded-b-[40px] items-center pt-16">
      {/* Welcome Message */}
      <Text className="text-2xl font-bold text-gray-800 mb-8">
        Welcome back, John!
      </Text>
      <Text className="text-gray-500 mb-12">
        Ready to scan your gym machine?
      </Text>

      {/* Scan Machine Button */}
      <TouchableOpacity className="bg-blue-500 w-64 h-64 rounded-full items-center justify-center shadow-lg">
        <Ionicons name="camera-outline" size={60} color="white" />
        <Text className="text-white text-lg font-semibold mt-4">
          Scan Machine
        </Text>
      </TouchableOpacity>

      {/* Optional: small tip text */}
      <Text className="text-gray-400 mt-6 px-12 text-center">
        Point your camera at a machine and get instant exercise suggestions!
      </Text>
    </View>
  );
}
