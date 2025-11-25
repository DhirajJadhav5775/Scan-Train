import BottomSheet from "@gorhom/bottom-sheet";
import React, { useMemo, useRef } from "react";
import { Text, TouchableOpacity, View } from "react-native";

export default function OnBoardingSheet() {
  const bottomSheetRef = useRef<BottomSheet>(null);

  const snapPoints = useMemo(() => ["40%", "70%"], []);

  return (
    <View className="flex-1 justify-center items-center">
      <TouchableOpacity onPress={() => bottomSheetRef.current?.expand()}>
        <Text>Get Started</Text>
      </TouchableOpacity>

      <BottomSheet ref={bottomSheetRef} index={-1} snapPoints={snapPoints}>
        <View className="p-6 flex-1 justify-center">
          <Text className="text-xl font-bold text-center mb-4">Welcome!</Text>
          <TouchableOpacity className="bg-blue-500 p-4 rounded mb-4">
            <Text className="text-white text-center">Login</Text>
          </TouchableOpacity>
          <TouchableOpacity className="bg-green-500 p-4 rounded mb-4">
            <Text className="text-white text-center">Sign Up</Text>
          </TouchableOpacity>
          <TouchableOpacity className="bg-gray-200 p-4 rounded">
            <Text className="text-black text-center">Continue as Guest</Text>
          </TouchableOpacity>
        </View>
      </BottomSheet>
    </View>
  );
}
