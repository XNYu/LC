package HashTable;

import java.util.*;

public class LC347 {
        //version1 桶排序 bucket sort 需要满足 数的范围已知的情况下,才能设array来存它
        // public List<Integer> topKFrequent(int[] nums, int k) {
        //     List<Integer>[] bucket = new List[nums.length+1];//注意这里的初始化过程
        //     HashMap<Integer, Integer> map = new HashMap();
        //     for(int i =0 ;i< nums.length; i++){
        //         map.put(nums[i],map.getOrDefault(nums[i],0)+1);//map.put; 这里用的是nums[i],不是i
        //     }
        //     for(int n: map.keySet() ){//keySet没有s
        //         int frequency = map.get(n);
        //         if(bucket[frequency] ==null){
        //             System.out.println(frequency+"is null");
        //             bucket[frequency]= new ArrayList();//List本身是抽象的,不能初始化 new List()
        //         }
        //         bucket[frequency].add(n);
        //     }
        //     List <Integer> ans = new ArrayList();
        //     for(int i =bucket.length-1; i>=0&& k>0;i--){//length-1别忘了
        //         if(bucket[i]!=null){
        //             ans.addAll(bucket[i]);
        //             k-=bucket[i].size();//list用size()
        //         }
        //     }
        //     return ans;
        // }


        //verison6专门移到这里对比
        //version6 最快的方法,还是用的version1的bucket,主要是因为别的更新hashmap太慢,这题用array实现了hashmap,而且test的max和min差值小,要不遍历时间很长
//     public List<Integer> topKFrequent(int[] nums, int k) {
//         List<Integer> res = new ArrayList<Integer>();

//         int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, maxFreq = 0;
//         for (int num : nums) {
//             if (num > max) max = num;
//             if (num < min) min = num;
//         }
//         int[] freq = new int[max-min + 1];//根据每个数来设array
//         for (int num : nums) {
//             freq[num-min]++;
//             if (maxFreq < freq[num-min]) maxFreq = freq[num-min];//找到最大次数
//         }
//         ArrayList<Integer>[] bu = new ArrayList[maxFreq + 1];//bucket
//         for (int i = 0; i < freq.length; i++) {//主要是因为这题test的max和min差值小,要不遍历时间很长
//             int in = freq[i];
//             if (in <= 0) continue;
//             if (bu[in] == null) bu[in] = new ArrayList<>();
//             bu[in].add(i+min);//用index记录次数,list记录数字
//         }
//         for(int i = maxFreq; i >= 0; i--) {//从大到小往里add k个
//             if (bu[i] != null) {
//                 for (Integer num : bu[i])
//                     if (k-- > 0)
//                         res.add(num);
//                     else return res;
//             }
//         }
//         return res;
//     }

        //version7提前对比 找到minmax用array实现hashmap,priotiryqueue根据
        public List<Integer> topKFrequent(int[] nums, int k) {
            //find min and max
            int min=nums[0],max=nums[0];
            for(int val:nums){
                if(val<min)
                    min=val;
                if(val>max)
                    max=val;
            }
            int freq[]=new int[max-min+1];
            for(int i=0;i<nums.length;i++){
                freq[nums[i]-min]++;
            }
            Queue<Integer> q=new PriorityQueue(nums.length,Collections.reverseOrder());
            //nums.length是设置的初始化大小,使用Collections.reverseOrder(),变递减

            for(int i=0;i<freq.length;i++)q.offer(freq[i]);

            for(int i=0;i<k-1;i++)q.poll();

            int limit=q.poll();//找到k的界限

            List<Integer> lst= new ArrayList<>();

            for(int i=0;i<freq.length;i++){//找到所有大于界限的,总共k个
                if(freq[i]>=limit){
                    lst.add(i+min);
                }
            }
            return lst;
        }
        //version3 原理同2,不同在于将每次多与k个的最小删除,只保留k个,注意反向输出
        // public List<Integer> topKFrequent(int[] nums, int k) {
        //     HashMap<Integer, Integer>map = new HashMap();
        //     for(int i =0;i<nums.length;i++){
        //         map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        //     }
        //     PriorityQueue<Map.Entry<Integer,Integer>> minHeap = new PriorityQueue<>((a,b)->(a.getValue()-b.getValue()));//a-b也有括号
        //     for(Map.Entry<Integer,Integer> entry: map.entrySet()){
        //         minHeap.add(entry);
        //         if(minHeap.size()>k)minHeap.poll();
        //     }
        //     List<Integer> res = new ArrayList();
        //     //for(int key : minHeap.keySet()) res.add(key);不是map,没有keysets方法
        //     while(!minHeap.isEmpty())res.add(0,minHeap.poll().getKey());//每次都放在第0位,因为是最小堆,所以需要反向
        //     return res;
        // }
        //version4 使用treemap 因为其pollLastEntry会poll出key最大的entry,用过getvalue获取最大的key,直到获取k个
        // public List<Integer> topKFrequent(int[] nums, int k) {
        //     HashMap<Integer,Integer> map = new HashMap();
        //     for(int i=0; i<nums.length; i++){
        //         map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        //     }
        //     TreeMap<Integer,List<Integer>> freqMap = new TreeMap<>();
        //     for(int key: map.keySet() ){
        //         int freq= map.get(key);
        //         if(!freqMap.containsKey(freq)) freqMap.put(freq,new LinkedList());//不是add
        //         freqMap.get(freq).add(key);
        //     }
        //     List<Integer> res = new LinkedList();//
        //     while(res.size()<k){
        //         res.addAll(freqMap.pollLastEntry().getValue());//pollLastEntry会poll出key最大的entry
        //     }
        //     return res;
        // }
        //version5 最好写的方法
//     public List<Integer> topKFrequent(int[] nums, int k) {
//         if(nums == null || nums.length == 0)
//             return null;

//         Map<Integer, Integer> map = new HashMap<>();
//         List<Integer> result = new LinkedList<>();
//         for (int num : nums) {
//             map.put(num, map.getOrDefault(num, 0) + 1);
//         }

//         List<Integer> count = new ArrayList<>(map.values());//keySet()和values()
//         Collections.sort(count);//是Collections
//         int threshold = count.get(count.size() - k);//直接找到最大k个的次数
//         for (int num : map.keySet()) {//大于的加进去
//            if(map.get(num) >= threshold)
//                result.add(num);
//         }
//         return result;
//     }


    class N {
        int val;
        int count;
        public N(int val, int count) {
            this.val = val;
            this.count = count;
        }
    }
    public List<Integer> topKFrequent2(int[] nums, int k) {
        PriorityQueue<N> queue = new PriorityQueue<>(new Comparator<N>() {
            @Override
            public int compare(N o1, N o2) {
                return o2.count-o1.count;
            }
        });
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            int count = map.getOrDefault(n, 0);
            map.put(n, count + 1);
        }
        for (Map.Entry e : map.entrySet()) {
            N n = new N((int)e.getKey(), (int)e.getValue());
            queue.offer(n);
        }
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            list.add(queue.poll().val);
        }
        return list;
    }
}
