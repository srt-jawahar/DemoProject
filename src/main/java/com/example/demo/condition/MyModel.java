package com.example.demo.condition;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="PLAYER_STATS_TBL")
public class MyModel 
{
	@Id
	@Column(name="PLAYER_ID")
	@SequenceGenerator(name = "SCREENS_SEQ", sequenceName = "SCREENS_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SCREENS_SEQ")
	private Long player_id;
	
	@Column(name="PLAYER_NAME")
	private String name;
	
	@Column(name="RUNS")
	private int runs;
	
	@Column(name="BALLS")
	private int balls;
	
	@Column(name="TEAM")
	private String team;

	
	public MyModel(Long player_id, String name, int runs, int balls, String team) {
		super();
		this.player_id = player_id;
		this.name = name;
		this.runs = runs;
		this.balls = balls;
		this.team = team;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPlayer_id() {
		return player_id;
	}

	public void setPlayer_id(Long player_id) {
		this.player_id = player_id;
	}

	public int getRuns() {
		return runs;
	}

	public void setRuns(int runs) {
		this.runs = runs;
	}

	public int getBalls() {
		return balls;
	}

	public void setBalls(int balls) {
		this.balls = balls;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	@Override
	public String toString() {
		return "MyModel [player_id=" + player_id + ", name=" + name + ", runs=" + runs + ", balls=" + balls + ", team="
				+ team + "]";
	}
	
	
}
