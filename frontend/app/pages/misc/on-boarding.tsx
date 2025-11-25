import React, { useState } from "react";
import {
  ImageBackground,
  Modal,
  Pressable,
  Text,
  TouchableOpacity,
  TouchableWithoutFeedback,
  View,
} from "react-native";
import { SafeAreaView } from "react-native-safe-area-context";

const OnBoarding = () => {
  const [modalVisible, setModalVisible] = useState(false);

  return (
    <ImageBackground
      source={require("../../../assets/bgs/onboarding_bg.png")}
      className="flex-1"
      resizeMode="cover"
    >
      <SafeAreaView className="flex-1 items-start justify-end p-6 bg-black/60">
        {/* Logo */}
        <Text className="text-2xl font-bold text-white/70 mb-4">
          Scan&Train
        </Text>

        {/* Headline */}
        <Text className="text-6xl font-bold text-white mb-2">
          Smarter Workouts. Just Scan & Train.
        </Text>

        {/* Subtext */}
        <Text className="text-white/80 text-xl my-6">
          Point your camera at any machine and get instant, personalized
          exercise guidance.
        </Text>

        {/* Get Started Button */}
        <View className="rounded-3xl bg-white h-14 overflow-hidden w-full">
          <Pressable
            android_ripple={{ color: "#C1D9D8" }}
            className="w-full h-full flex items-center justify-center"
            onPress={() => setModalVisible(true)}
          >
            <Text className="text-lg text-black font-bold">Get Started</Text>
          </Pressable>
        </View>

        {/* Floating Glassmorphic Modal */}
        <Modal
          animationType="fade"
          transparent={true}
          visible={modalVisible}
          onRequestClose={() => setModalVisible(false)}
        >
          <TouchableWithoutFeedback onPress={() => setModalVisible(false)}>
            <View className="flex-1 bg-black/30 justify-center items-center px-6">
              <TouchableWithoutFeedback>
                <View className="w-full rounded-3xl p-6 items-center bg-black/40 backdrop-blur-lg">
                  {/* Title */}
                  <Text className="text-2xl font-bold text-white mb-6 text-center">
                    Welcome!
                  </Text>

                  {/* Buttons */}
                  <TouchableOpacity
                    className="w-full bg-white py-4 rounded-2xl mb-4 shadow-lg"
                    onPress={() => setModalVisible(false)}
                  >
                    <Text className="text-black text-center text-lg font-semibold">
                      Login
                    </Text>
                  </TouchableOpacity>

                  <TouchableOpacity
                    className="w-full bg-white py-4 rounded-2xl mb-4 shadow-lg"
                    onPress={() => setModalVisible(false)}
                  >
                    <Text className="text-black text-center text-lg font-semibold">
                      Sign Up
                    </Text>
                  </TouchableOpacity>

                  <TouchableOpacity
                    className="w-full py-4 rounded-2xl border border-white/40 mb-4 bg-white/10"
                    onPress={() => setModalVisible(false)}
                  >
                    <Text className="text-white text-center text-lg font-semibold">
                      Continue as Guest
                    </Text>
                  </TouchableOpacity>

                  {/* Terms & Privacy */}
                  <Text className="text-xs text-white/70 text-center mt-2 leading-5">
                    By continuing you agree to our{" "}
                    <Text className="underline text-white">
                      Terms of Service
                    </Text>{" "}
                    &{" "}
                    <Text className="underline text-white">Privacy Policy</Text>
                    .
                  </Text>
                </View>
              </TouchableWithoutFeedback>
            </View>
          </TouchableWithoutFeedback>
        </Modal>
      </SafeAreaView>
    </ImageBackground>
  );
};

export default OnBoarding;
