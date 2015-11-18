package com.example.seonghoon.yeodam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.ParseException;
import java.util.ArrayList;

public class PlanManager implements IPlanIOhandler{

	public final int MaxPlanCount = 100;
	//여러 플랜을 저장
		private ArrayList<Plan> planContainer= new ArrayList<Plan>();
		
	//플랜코드와 씬들의 릴레이션을 저장
		private ArrayList<PlanRelation> planRelations = new ArrayList<PlanRelation>();


	//플랜들의 제목을 읽어서 스트링배열로 출력해줌
		public String[] getAllPlanName(){
			String[] myString = new String[planContainer.size()];

			for(int i = 0 ; i < planContainer.size();i++) {
				myString[i] = new String();
				myString[i] =  planContainer.get(i).getPlanName();

			}
			return myString;
		}

		
		public Plan getPlanbyIndex(int i) { 
			
			return planContainer.get(i);
		}
		
		public int getPlanSize() { 
			
			return planContainer.size();
		}
		
		public int addPlan(Plan plan){
			
			planContainer.add(plan);
			return 0;
		}
		
		public int addPlanRelation(PlanRelation planRelation) { 
			planRelations.add(planRelation);
			return 0;
		}
		
		public int enrollPlanRelation() { 
			//플랜-릴레이션 테이블을 한번 순서대로 읽어서
			for( PlanRelation pRel : planRelations ) { 
				
				int planCode = pRel.getPlanCode();
				int sceneCode = pRel.getSceneCode();

				//씬코드를 테마에 등록시킴
				for( Plan p : planContainer){
					if(p.getPlanCode()==planCode) { 
						p.addSceneCode(sceneCode);
					}
					
				}
			}
			
			
		
			return 0;
		}
		//현재 최근에 사용된 플 Plan 의 번호를 넘겨줌
		public int getRecentCode() {
			
			int MaxNumber=0;
			for( Plan p : planContainer) { 
				if(p.getPlanCode()>MaxNumber) { 
					MaxNumber = p.getPlanCode();
				}
			}
			if(MaxNumber==0) { 
				MaxNumber=90001;
			}
			
			return MaxNumber;
		}

		
		//파일로 부터 Plan 내용을 읽어옴
		@Override
		public int read(InputStream inputStream) throws IOException, ParseException {
			int skipFrist=0;
			String[] spiltBuf;
			String readLine ;
			BufferedReader sceneBuf = new BufferedReader(new InputStreamReader(inputStream,"euc-kr"));
			
			while((readLine = sceneBuf.readLine())!=null) { 
				if(skipFrist==0) { skipFrist++;continue;}

				spiltBuf = readLine.split(",");		
				Plan planBuffer = new Plan();
				
				planBuffer.setPlanName(spiltBuf[0]);
				planBuffer.setPlanCode(Integer.parseInt(spiltBuf[1]));
				planBuffer.setStartDate(Long.parseLong(spiltBuf[2]));
				planBuffer.setEndDate(Long.parseLong(spiltBuf[3]));

				addPlan(planBuffer);
			}
			//전체 플랜 릴레이션을 등록함
			sceneBuf.close();
			
			return 0;
		}
		//파일로 부터 Plan의 테이블을 읽어옴
		@Override
		public int readRelation(InputStream inputStream) throws IOException {
			String[] spiltBuf;
			String readLine;			
			int skipFrist=0;
			BufferedReader sceneBuf = new BufferedReader(new InputStreamReader(inputStream,"euc-kr"));
			
			while((	 readLine = sceneBuf.readLine())!=null) { 
				if(skipFrist==0) { skipFrist++;continue;}
				spiltBuf = readLine.split(",");		
				PlanRelation relationBuffer = new PlanRelation();
				relationBuffer.setPlanCode(Integer.parseInt(spiltBuf[0]));
				relationBuffer.setSceneCode(Integer.parseInt(spiltBuf[1]));
				

				addPlanRelation(relationBuffer);
			}
		
			sceneBuf.close();
			return 0;
		}

		// 현재 Plan들을 파일로 저장함
		@Override
		public int save(PlanManager planManager) throws IOException {
			int planCount = planManager.getPlanSize();
			File filew = new File("PlanData.csv");
			BufferedWriter savebuf = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filew),"euc-kr"));
			
			savebuf.write("planName,planId,startDate,endDate");
			savebuf.newLine();
			
			for(int i =0 ; i < planCount ; i++) { 
				Plan myplan = planManager.getPlanbyIndex(i);
				savebuf.write(myplan.getPlanName()+","+myplan.getPlanCode()+","+
								myplan.getStartDate().getTime()+","+
									myplan.getEndDate().getTime());
				savebuf.newLine();
			}
			savebuf.close();
			return 0;
		}

}
