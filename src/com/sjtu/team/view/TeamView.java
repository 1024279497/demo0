package com.sjtu.team.view;

import com.sjtu.team.domain.Employee;
import com.sjtu.team.domain.Programmer;
import com.sjtu.team.service.NameListService;
import com.sjtu.team.service.TeamException;
import com.sjtu.team.service.TeamService;

public class TeamView {
    private NameListService listSvc = new NameListService();
    private TeamService teamSvc = new TeamService();

    public void enterMainMenu() throws TeamException {
        boolean loopFlag = true;
        char menu =0;
        while(loopFlag){
            if(menu!='1'){
                listAllEmployees();
            }
            System.out.println("1-团队列表 2-添加团队成员 3-删除团队成员 4-退出 请选择(1-4):");
            menu = TSUtility.readMenuSelection();
            switch(menu){
                case '1':
                    getTeam();
                    break;
                case '2':
                    addMembers();
                    break;
                case '3':
                    deleteMember();
                    break;
                case '4':
                    System.out.println("是否要退出(Y/N):");
                    char isExit = TSUtility.readConfirmSelection();
                    if(isExit=='Y'){
                        loopFlag = false;
                    }
                    break;
            }
        }
    }

    private void listAllEmployees(){
        System.out.println("-----------------------------------开发调度软件----------------------");

        Employee[] employees = listSvc.getAllEmployees();
        if(employees.length==0||employees == null){
            System.out.println("公司中没有任何员工的信息！");
        }else{
            System.out.println("ID\t姓名\t年龄\t工资\t职位\t状态\t奖金\t股票\t使用设备");
            for(int i=0;i< employees.length;i++){
                System.out.println(employees[i]);
            }
        }
    }

    private void getTeam(){
        System.out.println("----------------团队成员列表---------------");

        Programmer[] team = teamSvc.getTeam();
        if(team.length==0||team==null){
            System.out.println("团队中没有任何成员");
        }else{
            System.out.println("TID/ID\t姓名\t年龄\t工资\t职位\t奖金\t股票\n");
            for(int i =0;i<team.length;i++){
                System.out.println(team[i].getDetailsTeam());
            }
        }
        System.out.println("-----------------------------------------");
    }

    private void addMembers() {
        System.out.println("---------------------添加成员------------------");
        System.out.println("请输入要添加的人员序号：");
        int selection = TSUtility.readInt();
        try {
            Employee employee = listSvc.getEmployee(selection);
            teamSvc.addMember(employee);
            System.out.println("添加成功");
        } catch (TeamException e) {
            System.out.println("添加失败的原因："+e.getMessage());
        }
        TSUtility.readReturn();
    }

    private void deleteMember(){
        System.out.println("--------------------删除成员------------------");
        System.out.println("请输入要删除员工的TID");
        int memberId = TSUtility.readInt();
        System.out.println("确认是否删除(Y/N)");
        char isDelete = TSUtility.readConfirmSelection();
        if(isDelete =='N'){
            return;
        }
        try {
            teamSvc.removeMember(memberId);
            System.out.println("删除成功");
        } catch (TeamException e) {
            System.out.println("删除失败的原因："+e.getMessage());
        }
        TSUtility.readReturn();
    }

    public static void main(String[] args)  {
        TeamView teamview = new TeamView();

        try {
            teamview.enterMainMenu();
        } catch (TeamException e) {
            System.out.println(e.getMessage());
        }
    }
}
