package Graph;

import java.util.LinkedList;

public class CourseSchedule207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        LinkedList<Integer> queue = new LinkedList<>();
        int[] inDegree = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            inDegree[prerequisites[i][0]]++;
        }

        for (int i = 0; i < numCourses; i++) {
            if(inDegree[i] == 0){
                queue.offer(i);
            }
        }

        int count = 0;
        while (!queue.isEmpty()){
            int course = queue.poll();
            count++;
            for (int i = 0; i < prerequisites.length; i++) {
                if(prerequisites[i][1] == course){
                    inDegree[prerequisites[i][0]]--;
                    if(inDegree[prerequisites[i][0]] == 0){
                        queue.offer(prerequisites[i][0]);
                    }
                }
            }
        }

        return count == numCourses;
    }
}
