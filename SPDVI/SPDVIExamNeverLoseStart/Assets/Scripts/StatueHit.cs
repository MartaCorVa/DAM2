using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class StatueHit : MonoBehaviour
{
    private ScoreControl scoreScript;
    [SerializeField]
    private Text scoreText;
    private void OnCollisionEnter(Collision collision)
    {
        if (collision.gameObject.name.Contains("book"))
        {
            Destroy(gameObject);
            scoreText.text = "Score: " + scoreScript.AddScore().ToString();
        }
    }
    
    // Start is called before the first frame update
    void Start()
    {
        scoreScript = GetComponent<ScoreControl>();
    }

    // Update is called once per frame
    void Update()
    {

    }
}
