package com.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SmallestSufficieneTeam {

	public static void main(String[] args) {
		SmallestSufficieneTeam s = new SmallestSufficieneTeam();
		String req[] = { "algorithms", "math", "java", "reactjs", "csharp", "aws" };
		List<List<String>> people = new ArrayList<>();
		people.add(Arrays.asList("algorithms", "math", "java"));
		people.add(Arrays.asList("algorithms", "math", "reactjs"));
		people.add(Arrays.asList("java", "csharp", "aws"));
		people.add(Arrays.asList("reactjs", "csharp"));
		people.add(Arrays.asList("csharp", "math"));
		people.add(Arrays.asList("aws", "java"));
		System.out.println(s.smallestSufficientTeam(req, people));
	}

	Set<Integer> ans;
	int team;

	public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
		int n = req_skills.length;
		// System.out.println(n);
		int m = people.size();
		ans = new HashSet<>();
		team = Integer.MAX_VALUE;
		Map<Integer, Set<String>> st = new HashMap<>();
		for (int i = 0; i < m; i++) {
			st.put(i, new HashSet<>(people.get(i)));
		}
		List<Integer> res = new ArrayList<>();
		justDoIt(req_skills, st, res, 0, 0);
		int t = 0;
		int f[] = new int[ans.size()];
		for (int a : ans) {
			f[t++] = a;
		}
		return f;
	}

	private void justDoIt(String[] req_skills, Map<Integer, Set<String>> people, List<Integer> res, int s, int p) {

		// System.out.println(s);
		if (s >= req_skills.length) {
			 System.out.println(res);
			Set<Integer> temp = new HashSet<>(res);
			if (temp.size() < ans.size()) {
				ans = new HashSet<>(res);
				team = res.size();
			} else if (ans.isEmpty()) {
				ans = new HashSet<>(res);
				team = res.size();
			}
			return;
		}
		if (s >= req_skills.length || p >= people.size())
			return;

		String str = req_skills[s];
		for (int i = 0; i < people.size(); i++) {
			Set<String> sp = people.get(i);
			if (sp.contains(str)) {
				res.add(i);
				justDoIt(req_skills, people, res, s + 1, p);
				res.remove(res.size() - 1);
			}

		}

		// justDoIt(req_skills,people,res,s,p);
	}
}
