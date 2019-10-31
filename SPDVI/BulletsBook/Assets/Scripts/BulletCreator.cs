﻿using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class BulletCreator : MonoBehaviour
{
    public GameObject projectilePrefabRef;
    public float thrust = 6.0f;
    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        if (Input.GetKeyDown(KeyCode.Mouse0))
        {
            GameObject projectile = Instantiate(projectilePrefabRef, transform.position, Quaternion.identity);
            projectile.GetComponent<Rigidbody>().AddForce(transform.forward * thrust, ForceMode.Impulse);
            Destroy(projectile, 2.0f);

        }
        float sides = Input.GetAxis("Horizontal");
        float upDown = Input.GetAxis("Vertical");
    }
}