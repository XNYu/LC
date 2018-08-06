package DFS;

import java.util.HashMap;
import java.util.*;

public class LC721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String, String> owner = new HashMap<>();
        HashMap<String, String> parent = new HashMap<>();
        HashMap<String, TreeSet<String>> union = new HashMap<>();
        for (List<String> act : accounts) {
            String name = act.get(0);
            for (int i = 1; i < act.size(); i++) {
                String mail = act.get(i);
                owner.put(mail, name);
                parent.put(mail, mail);
            }
        }
        for (List<String> a : accounts) {
            String head = find(a.get(1),parent);
            for (int i = 2; i < a.size(); i++) {
                parent.put(find(a.get(i),parent), head);
            }
        }
        for (List<String> a : accounts) {
            String head = find(a.get(1),parent);
            TreeSet<String> set = union.getOrDefault(head, new TreeSet<>());
            for (int i = 1; i < a.size(); i++) {
                set.add(a.get(i));
                union.put(head, set);
            }
        }
        List<List<String>> ans = new LinkedList<>();
        for (String p : union.keySet()) {
            List<String> emails = new LinkedList<>(union.get(p));
            emails.add(0, owner.get(p));
            ans.add(emails);
        }
        return ans;

    }

    public String find(String child, HashMap<String, String> parent) {
        while (!parent.get(child).equals(child)) {
            child = parent.get(child);
        }
        return child;
    }

    public List<List<String>> accountsMerge2(List<List<String>> accounts) {
        HashMap<String, ArrayList<ArrayList<String>>> map = new HashMap<>();
        for (List<String> list : accounts) {
            String name = list.get(0);
            ArrayList<ArrayList<String>> persons = map.getOrDefault(name, new ArrayList<>());

            ArrayList<ArrayList<String>> personsToUnion = new ArrayList<>();
            ArrayList<String> head = new ArrayList<>();
            boolean firstPerson = false;
            for (ArrayList<String> person:persons) {
                for (int i = 1; i < list.size(); i++) {
                    String curMail = list.get(i);
                    if(person.contains(curMail))
                    {
                        List<String> backup = new LinkedList<>(list);
                        backup.remove(0);
                        person.addAll(backup);
                        if (!firstPerson) {
                            firstPerson = true;
                            head = person;
                        } else {
                            System.out.println(person);
                            personsToUnion.add(person);
                        }
                        break;
                    }
                }
            }
            persons.remove(head);
            for (ArrayList<String> person : personsToUnion) {
                System.out.println(person);
                head.addAll(person);
                person.remove(person);
            }
            if (!firstPerson) {
                list.remove(0);
                persons.add(new ArrayList<>(list));
            }
            else
                persons.add(head);
            map.put(name, persons);
        }
        List<List<String>> ans = new LinkedList<>();
        for (String name : map.keySet()) {
            for (ArrayList<String> person : map.get(name)) {
                LinkedList<String> add = new LinkedList<>();
                add.add(name);
                HashSet<String> mails = new HashSet<>();
                mails.addAll(person);
                person = new ArrayList<>(mails);
                Collections.sort(person);
                add.addAll(person);
                ans.add(add);
            }
        }
        return ans;
    }
}
