using System;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.AI;

public class EnemyController : MonoBehaviour
{

    [SerializeField]
    private List<Transform> locations;
    private int nextLocation = 0;
    private NavMeshAgent _agent;

    // Start is called before the first frame update
    void Start()
    {
        _agent = GetComponent<NavMeshAgent>();
        MoveToNextPatrolLocation();
    }

    // Update is called once per frame
    void Update()
    {
        if ((_agent.remainingDistance < _agent.stoppingDistance) && !_agent.pathPending)
        {
            MoveToNextPatrolLocation();
        }
    }

    public void MoveToNextPatrolLocation()
    {
        if (locations.Count == 0) return;
        _agent.destination = locations[nextLocation].position;
        nextLocation = (nextLocation + 1) % locations.Count;
    }
}
