// class Solution {
//     public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
//         int[] arr=new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
//         int aliceMonth=Integer.parseInt(arriveAlice.substring(3,arriveAlice.length));
//         int aliceDay=Integer.parseInt(arriveAlice.substring(3,arriveAlice.length));
//         int bobMonth=Integer.parseInt(arriveBob.substring(3,arriveAlice.length));
//         int bobDay=Integer.parseInt(arriveBob.substring(3,arriveAlice.length));

//         int aliceLeaveMonth=Integer.parseInt(leaveAlice.substring(3,leaveAlice.length));
//         int aliceLeaveDay=Integer.parseInt(leaveAlice.substring(3,leaveAlice.length));
//         int bobLeaveMonth=Integer.parseInt(leaveBob.substring(3,leaveBob.length));
//         int bobLeaveDay=Integer.parseInt(leaveBob.substring(3,leaveBob.length));

//         int ans=0;
//         if(aliceMonth>bobMonth && aliceMonth<bobLeaveMonth || bobMonth>aliceMonth && bobMonth<aliceLeaveMonth){
//             if(aliceLeaveMonth<bobLeaveMonth){
//                 for(int i=aliceMonth;i<aliceLeaveMonth;i++){
//                     ans+=arr[i];
//                 }
//                 ans=ans+(arr[i-1]-aliceDay)+aliceLeaveDay;
//             }
//             else{
//                 for(int i=aliceMonth;i<bobLeaveMonth;i++){
//                     ans+=arr[i];
//                 }
//                 ans=ans+(arr[i-1]-aliceDay)+aliceLeaveDay;
//             }
//         }
//         if(aliceMonth==bobMonth){

//         }
//     }
// }

class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice,
                                 String arriveBob, String leaveBob) {

        int[] arr = new int[]{31, 28, 31, 30, 31, 30,
                              31, 31, 30, 31, 30, 31};

        int aliceMonth = Integer.parseInt(arriveAlice.substring(0, 2));
        int aliceDay = Integer.parseInt(arriveAlice.substring(3, 5));

        int bobMonth = Integer.parseInt(arriveBob.substring(0, 2));
        int bobDay = Integer.parseInt(arriveBob.substring(3, 5));

        int aliceLeaveMonth = Integer.parseInt(leaveAlice.substring(0, 2));
        int aliceLeaveDay = Integer.parseInt(leaveAlice.substring(3, 5));

        int bobLeaveMonth = Integer.parseInt(leaveBob.substring(0, 2));
        int bobLeaveDay = Integer.parseInt(leaveBob.substring(3, 5));

        int ans = 0;

        // Find the later arrival date
        int startMonth, startDay;

        if (aliceMonth > bobMonth ||
            (aliceMonth == bobMonth && aliceDay > bobDay)) {
            startMonth = aliceMonth;
            startDay = aliceDay;
        } else {
            startMonth = bobMonth;
            startDay = bobDay;
        }

        // Find the earlier leave date
        int endMonth, endDay;

        if (aliceLeaveMonth < bobLeaveMonth ||
            (aliceLeaveMonth == bobLeaveMonth && aliceLeaveDay < bobLeaveDay)) {
            endMonth = aliceLeaveMonth;
            endDay = aliceLeaveDay;
        } else {
            endMonth = bobLeaveMonth;
            endDay = bobLeaveDay;
        }

        // Check whether dates overlap
        if (startMonth > endMonth ||
            (startMonth == endMonth && startDay > endDay)) {
            return 0;
        }

        // Both dates are in the same month
        if (startMonth == endMonth) {
            ans = endDay - startDay + 1;
        } else {
            // Remaining days in the starting month
            ans += arr[startMonth - 1] - startDay + 1;

            // Complete months in between
            for (int i = startMonth + 1; i < endMonth; i++) {
                ans += arr[i - 1];
            }

            // Days in the ending month
            ans += endDay;
        }

        return ans;
    }
}